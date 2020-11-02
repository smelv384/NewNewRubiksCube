package RubiksCube;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Much of the basic code is from a tutorial by MeanRollerCoding, from
 * https://www.youtube.com/watch?v=KA6rJZOfTTQ&ab_channel=MeanRollerCoding
 */
public class CubeRenderer extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private Thread thread;
    private JFrame frame;
    private static String title = "3d renderer";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int CUBIE_HEIGHT = 30;
    private static boolean running = false;

    private RubiksCube renderCube;

    public CubeRenderer(RubiksCube renderCube) {
        this.frame = new JFrame();
        this.renderCube = renderCube;

        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
    }

    public static void initialize(RubiksCube renderCube) {
        CubeRenderer display = new CubeRenderer(renderCube);
        display.frame.setTitle(title);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }

    public synchronized void start() {
        running = true;
        this.thread = new Thread(this, "renderer.Display");
        this.thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60; //60 - number of updates per second - the number of updates per second
        double delta = 0;
        int frames = 0;


        //this is just updating x times per second
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;  //the % of time we have until the next update
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle(title + " | " + frames + " fps");
                frames = 0;
            }
        }
    }

    private void render() {
        final int BIG_SQUARE_SIZE = CUBIE_HEIGHT * 3 + CUBIE_HEIGHT;

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        g.setColor(Color.BLACK);
        g.fillRect(BIG_SQUARE_SIZE * 2, BIG_SQUARE_SIZE, BIG_SQUARE_SIZE, BIG_SQUARE_SIZE);
        g.fillRect(BIG_SQUARE_SIZE, BIG_SQUARE_SIZE * 2, BIG_SQUARE_SIZE * 3, BIG_SQUARE_SIZE);
        g.fillRect(BIG_SQUARE_SIZE * 2, BIG_SQUARE_SIZE * 3, BIG_SQUARE_SIZE, BIG_SQUARE_SIZE * 2);





        g.dispose();
        bs.show();

    }

    private void update() {

    }



}
