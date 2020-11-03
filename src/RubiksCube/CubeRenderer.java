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
        final int BIG_SQUARE_SIZE = CUBIE_HEIGHT + (CUBIE_HEIGHT / 3);

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        int offsetX = BIG_SQUARE_SIZE * 5;
        int offsetY = BIG_SQUARE_SIZE * 2;

        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);
        offsetX -= BIG_SQUARE_SIZE * 3;
        offsetY += BIG_SQUARE_SIZE * 3;
        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);
        offsetX += BIG_SQUARE_SIZE * 3;
        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);
        offsetX += BIG_SQUARE_SIZE * 3;
        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);
        offsetX -= BIG_SQUARE_SIZE * 3;
        offsetY += BIG_SQUARE_SIZE * 3;
        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);
        offsetY += BIG_SQUARE_SIZE * 3;
        createBlackSquare(g, offsetX, offsetY, BIG_SQUARE_SIZE);

        offsetX = BIG_SQUARE_SIZE * 2 + (CUBIE_HEIGHT / 6);
        offsetY = BIG_SQUARE_SIZE * 2 + (CUBIE_HEIGHT / 6);

        createCubeSquare(g, offsetX, offsetY, CUBIE_HEIGHT);

        g.dispose();
        bs.show();

    }

    /**
     * This method creates a 3x3 square of black squares, each 2 * (cubie height / 6) in width and height
     * @param g
     * @param offsetX
     * @param offsetY
     * @param bigSquareSize
     */
    private void createBlackSquare(Graphics g, int offsetX, int offsetY, int bigSquareSize) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.setColor(Color.BLACK);
                g.fillRect(offsetX, offsetY, bigSquareSize, bigSquareSize);
                offsetX += bigSquareSize;
            }
            offsetX -= bigSquareSize * 3;
            offsetY += bigSquareSize;
        }
    }

    private void createCubeSquare(Graphics g, int offsetX, int offsetY, int squareSize) {
        String cubeString = renderCube.printCube();
        int k = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                Color sideColor;
                switch(cubeString.charAt(k)) {
                    case 'O':
                        sideColor = Color.ORANGE;
                        break;
                    case 'R':
                        sideColor = Color.RED;
                        break;
                    case 'W':
                        sideColor = Color.WHITE;
                        break;
                    case 'Y':
                        sideColor = Color.YELLOW;
                        break;
                    case 'G':
                        sideColor = Color.GREEN;
                        break;
                    case 'B':
                        sideColor = Color.BLUE;
                        break;
                    default:
                        sideColor = Color.WHITE;
                        break;
                }
                    g.setColor(sideColor);
                    g.fillRect(offsetX, offsetY, squareSize, squareSize);
                    offsetX += squareSize + (squareSize / 3);


                k++;
            }
            k++;
            offsetX -= 9 * (squareSize + (squareSize / 3));
            offsetY += (squareSize + (squareSize / 3));
        }



    }

    private void update() {

    }



}
