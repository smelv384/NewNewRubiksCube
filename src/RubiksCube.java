
public class RubiksCube {


    //Centers - only one direction distinction needed
    private Center fro;
    private Center bac;
    private Center bot;
    private Center top;
    private Center rig;
    private Center lef;

    //Edges - two direction distinctions needed
    private CornerEdge froTop;
    private CornerEdge froLef;
    private CornerEdge froBot;
    private CornerEdge froRig;
    private CornerEdge topLef;
    private CornerEdge topRig;
    private CornerEdge botLef;
    private CornerEdge botRig;
    private CornerEdge bacTop;
    private CornerEdge bacLef;
    private CornerEdge bacBot;
    private CornerEdge bacRig;

    //Corners - three direction distinctions needed
    private CornerEdge froLefTop;
    private CornerEdge froLefBot;
    private CornerEdge froRigTop;
    private CornerEdge froRigBot;
    private CornerEdge bacLefTop;
    private CornerEdge bacLefBot;
    private CornerEdge bacRigTop;
    private CornerEdge bacRigBot;

    //constructor - constructors generally ordered front, top, bottom, left, right, back
    public RubiksCube() {
        fro = new Center(CubePiece.Colour.RED);
        top = new Center(CubePiece.Colour.YELLOW);
        bot = new Center(CubePiece.Colour.WHITE);
        lef = new Center(CubePiece.Colour.BLUE);
        rig = new Center(CubePiece.Colour.GREEN);
        bac = new Center(CubePiece.Colour.ORANGE);

        froTop = new CornerEdge(null, CubePiece.Colour.YELLOW, CubePiece.Colour.RED);
        froBot = new CornerEdge(null, CubePiece.Colour.WHITE, CubePiece.Colour.RED);
        froLef = new CornerEdge(CubePiece.Colour.BLUE, null, CubePiece.Colour.RED);
        froRig = new CornerEdge(CubePiece.Colour.GREEN, null, CubePiece.Colour.RED);
        topLef = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.YELLOW, null);
        topRig = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.YELLOW, null);
        botLef = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.WHITE, null);
        botRig = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.WHITE, null);
        bacTop = new CornerEdge(null, CubePiece.Colour.YELLOW, CubePiece.Colour.ORANGE);
        bacBot = new CornerEdge(null, CubePiece.Colour.WHITE, CubePiece.Colour.ORANGE);
        bacLef = new CornerEdge(CubePiece.Colour.BLUE, null, CubePiece.Colour.ORANGE);
        bacRig = new CornerEdge(CubePiece.Colour.GREEN, null, CubePiece.Colour.ORANGE);

        froLefTop = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.YELLOW, CubePiece.Colour.RED);
        froLefBot = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.WHITE, CubePiece.Colour.RED);
        froRigTop = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.YELLOW, CubePiece.Colour.RED);
        froRigBot = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.WHITE, CubePiece.Colour.RED);
        bacLefTop = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.YELLOW, CubePiece.Colour.ORANGE);
        bacLefBot = new CornerEdge(CubePiece.Colour.BLUE, CubePiece.Colour.WHITE, CubePiece.Colour.ORANGE);
        bacRigTop = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.YELLOW, CubePiece.Colour.ORANGE);
        bacRigBot = new CornerEdge(CubePiece.Colour.GREEN, CubePiece.Colour.WHITE, CubePiece.Colour.ORANGE);
    }

    /**
     * Prints each portion of the cube as a flat cube of 6 sections of 9 cube sides
     */
    public void printCube() {
        System.out.printf("   %c%c%c   \n",
                bacLefBot.getZ().toString().charAt(0), bacBot.getZ().toString().charAt(0), bacRigBot.getZ().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                bacLef.getZ().toString().charAt(0), bac.getColour().toString().charAt(0), bacRig.getZ().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                bacLefTop.getZ().toString().charAt(0), bacTop.getZ().toString().charAt(0), bacRigTop.getZ().toString().charAt(0));

        System.out.printf("%c%c%c%c%c%c%c%c%c\n",
                bacLefBot.getX().toString().charAt(0), bacLef.getX().toString().charAt(0), bacLefTop.getX().toString().charAt(0),
                bacLefTop.getY().toString().charAt(0), bacTop.getY().toString().charAt(0), bacRigTop.getY().toString().charAt(0),
                bacRigTop.getX().toString().charAt(0), bacRig.getX().toString().charAt(0), bacRigBot.getX().toString().charAt(0));
        System.out.printf("%c%c%c%c%c%c%c%c%c\n",
                botLef.getX().toString().charAt(0), lef.getColour().toString().charAt(0), topLef.getX().toString().charAt(0),
                topLef.getY().toString().charAt(0), top.getColour().toString().charAt(0), topRig.getY().toString().charAt(0),
                topRig.getX().toString().charAt(0), rig.getColour().toString().charAt(0), botRig.getX().toString().charAt(0));

        System.out.printf("%c%c%c%c%c%c%c%c%c\n",
                froLefBot.getX().toString().charAt(0), froLef.getX().toString().charAt(0), froLefTop.getX().toString().charAt(0),
                froLefTop.getY().toString().charAt(0), froTop.getY().toString().charAt(0), froRigTop.getY().toString().charAt(0),
                froRigTop.getX().toString().charAt(0), froRig.getX().toString().charAt(0), froRigBot.getX().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                froLefTop.getZ().toString().charAt(0), froTop.getZ().toString().charAt(0), froRigTop.getZ().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                froLef.getZ().toString().charAt(0), fro.getColour().toString().charAt(0), froRig.getZ().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                froLefBot.getZ().toString().charAt(0), froBot.getZ().toString().charAt(0), froRigBot.getZ().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                froLefBot.getY().toString().charAt(0), froBot.getY().toString().charAt(0), froRigBot.getY().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                botLef.getY().toString().charAt(0), bot.getColour().toString().charAt(0), botRig.getY().toString().charAt(0));

        System.out.printf("   %c%c%c   \n",
                bacLefBot.getY().toString().charAt(0), bacBot.getY().toString().charAt(0), bacRigBot.getY().toString().charAt(0));
    }

    public void scramble() {
        for (int i = 0; i < 30; i++) {
            int max = 18;
            int seeding = (int) (Math.random() * (max + 1));
            switch(seeding) {
                case 0:
                    turnF();
                    break;
                case 1:
                    turnU();
                    break;
                case 2:
                    turnD();
                    break;
                case 3:
                    turnR();
                    break;
                case 4:
                    turnL();
                    break;
                case 5:
                    turnB();
                    break;
                case 6:
                    turnFP();
                    break;
                case 7:
                    turnUP();
                    break;
                case 8:
                    turnDP();
                    break;
                case 9:
                    turnRP();
                    break;
                case 10:
                    turnLP();
                    break;
                case 11:
                    turnBP();
                    break;
                case 12:
                    turnF2();
                    break;
                case 13:
                    turnU2();
                    break;
                case 14:
                    turnD2();
                    break;
                case 15:
                    turnR2();
                    break;
                case 16:
                    turnL2();
                    break;
                case 17:
                    turnB2();
                    break;
            }
        }
    }

    /**
     * This section of methods is the turns.  They follow the format: shift corners, swap corner colours,
     * shift edges, swap edge colours.
     **/
    public void turnF() {
        CornerEdge holder = froRigTop;
        froRigTop = froLefTop;
        froLefTop = froLefBot;
        froLefBot = froRigBot;
        froRigBot = holder;

        froRigTop.swapXY();
        froLefTop.swapXY();
        froLefBot.swapXY();
        froRigBot.swapXY();

        holder = froTop;
        froTop = froLef;
        froLef = froBot;
        froBot = froRig;
        froRig = holder;

        froTop.swapXY();
        froLef.swapXY();
        froBot.swapXY();
        froRig.swapXY();
    }

    public void turnU() {
        CornerEdge holder = froRigTop;
        froRigTop = bacRigTop;
        bacRigTop = bacLefTop;
        bacLefTop = froLefTop;
        froLefTop = holder;

        froRigTop.swapXZ();
        bacRigTop.swapXZ();
        bacLefTop.swapXZ();
        froLefTop.swapXZ();

        holder = froTop;
        froTop = topRig;
        topRig = bacTop;
        bacTop = topLef;
        topLef = holder;

        froTop.swapXZ();
        topRig.swapXZ();
        bacTop.swapXZ();
        topLef.swapXZ();
    }

    public void turnD() {
        CornerEdge holder = froRigBot;
        froRigBot = froLefBot;
        froLefBot = bacLefBot;
        bacLefBot = bacRigBot;
        bacRigBot = holder;

        froRigBot.swapXZ();
        froLefBot.swapXZ();
        bacLefBot.swapXZ();
        bacRigBot.swapXZ();

        holder = froBot;
        froBot = botLef;
        botLef = bacBot;
        bacBot = botRig;
        botRig = holder;

        froBot.swapXZ();
        botLef.swapXZ();
        bacBot.swapXZ();
        botRig.swapXZ();
    }

    public void turnR() {
        CornerEdge holder = froRigTop;
        froRigTop = froRigBot;
        froRigBot = bacRigBot;
        bacRigBot = bacRigTop;
        bacRigTop = holder;

        froRigTop.swapYZ();
        froRigBot.swapYZ();
        bacRigBot.swapYZ();
        bacRigTop.swapYZ();

        holder = froRig;
        froRig = botRig;
        botRig = bacRig;
        bacRig = topRig;
        topRig = holder;

        froRig.swapYZ();
        botRig.swapYZ();
        bacRig.swapYZ();
        topRig.swapYZ();
    }

    public void turnL() {
        CornerEdge holder = froLefTop;
        froLefTop = bacLefTop;
        bacLefTop = bacLefBot;
        bacLefBot = froLefBot;
        froLefBot = holder;

        froLefTop.swapYZ();
        bacLefTop.swapYZ();
        bacLefBot.swapYZ();
        froLefBot.swapYZ();

        holder = froLef;
        froLef = topLef;
        topLef = bacLef;
        bacLef = botLef;
        botLef = holder;

        froLef.swapYZ();
        topLef.swapYZ();
        bacLef.swapYZ();
        botLef.swapYZ();
    }

    public void turnB() {
        CornerEdge holder = bacRigTop;
        bacRigTop = bacRigBot;
        bacRigBot = bacLefBot;
        bacLefBot = bacLefTop;
        bacLefTop = holder;

        bacRigTop.swapXY();
        bacRigBot.swapXY();
        bacLefBot.swapXY();
        bacLefTop.swapXY();

        holder = bacTop;
        bacTop = bacRig;
        bacRig = bacBot;
        bacBot = bacLef;
        bacLef = holder;

        bacTop.swapXY();
        bacRig.swapXY();
        bacBot.swapXY();
        bacLef.swapXY();
    }

    /**
     * Reverse methods.  Implemented exactly the same as the regular methods, but go the opposite direction.  Follows
     * the same format.
     **/
    public void turnFP() {
        CornerEdge holder = froRigTop;
        froRigTop = froRigBot;
        froRigBot = froLefBot;
        froLefBot = froLefTop;
        froLefTop = holder;

        froRigTop.swapXY();
        froRigBot.swapXY();
        froLefBot.swapXY();
        froLefTop.swapXY();

        holder = froTop;
        froTop = froRig;
        froRig = froBot;
        froBot = froLef;
        froLef = holder;

        froTop.swapXY();
        froRig.swapXY();
        froBot.swapXY();
        froLef.swapXY();
    }

    public void turnUP() {


        CornerEdge holder = froRigTop;
        froRigTop = froLefTop;
        froLefTop = bacLefTop;
        bacLefTop = bacRigTop;
        bacRigTop = holder;

        froRigTop.swapXZ();
        froLefTop.swapXZ();
        bacLefTop.swapXZ();
        bacRigTop.swapXZ();

        holder = froTop;
        froTop = topLef;
        topLef = bacTop;
        bacTop = topRig;
        topRig = holder;

        froTop.swapXZ();
        topLef.swapXZ();
        bacTop.swapXZ();
        topRig.swapXZ();
    }

    public void turnDP() {
        CornerEdge holder = froLefBot;
        froLefBot = froRigBot;
        froRigBot = bacRigBot;
        bacRigBot = bacLefBot;
        bacLefBot = holder;

        froRigBot.swapXZ();
        froLefBot.swapXZ();
        bacLefBot.swapXZ();
        bacRigBot.swapXZ();

        holder = froBot;
        froBot = botRig;
        botRig = bacBot;
        bacBot = botLef;
        botLef = holder;

        froBot.swapXZ();
        botLef.swapXZ();
        bacBot.swapXZ();
        botRig.swapXZ();
    }

    public void turnRP() {
        CornerEdge holder = froRigTop;
        froRigTop = bacRigTop;
        bacRigTop = bacRigBot;
        bacRigBot = froRigBot;
        froRigBot = holder;

        froRigTop.swapYZ();
        bacRigTop.swapYZ();
        bacRigBot.swapYZ();
        froRigBot.swapYZ();

        holder = froRig;
        froRig = topRig;
        topRig = bacRig;
        bacRig = botRig;
        botRig = holder;

        froRig.swapYZ();
        topRig.swapYZ();
        bacRig.swapYZ();
        botRig.swapYZ();
    }

    public void turnLP() {
        CornerEdge holder = froLefTop;
        froLefTop = froLefBot;
        froLefBot = bacLefBot;
        bacLefBot = bacLefTop;
        bacLefTop = holder;

        froLefTop.swapYZ();
        froLefBot.swapYZ();
        bacLefBot.swapYZ();
        bacLefTop.swapYZ();

        holder = froLef;
        froLef = botLef;
        botLef = bacLef;
        bacLef = topLef;
        topLef = holder;

        froLef.swapYZ();
        botLef.swapYZ();
        bacLef.swapYZ();
        topLef.swapYZ();
    }

    public void turnBP() {
        CornerEdge holder = bacRigTop;
        bacRigTop = bacLefTop;
        bacLefTop = bacLefBot;
        bacLefBot = bacRigBot;
        bacRigBot = holder;

        bacRigTop.swapXY();
        bacLefTop.swapXY();
        bacLefBot.swapXY();
        bacRigBot.swapXY();

        holder = bacTop;
        bacTop = bacLef;
        bacLef = bacBot;
        bacBot = bacRig;
        bacRig = holder;

        bacTop.swapXY();
        bacLef.swapXY();
        bacBot.swapXY();
        bacRig.swapXY();
    }

    /**
     * Double turns.  Could be implemented outside of the cube, but are done inside cube object for ease of
     * transcription of solution algorithms.  To do: make this more efficient by just swapping pieces - will reduce
     * LOC in each command by 16
     **/
    public void turnF2() {
        turnF();
        turnF();
    }

    public void turnU2() {
        turnU();
        turnU();
    }

    public void turnD2() {
        turnD();
        turnD();
    }

    public void turnL2() {
        turnL();
        turnL();
    }

    public void turnR2() {
        turnR();
        turnR();
    }

    public void turnB2() {
        turnB();
        turnB();
    }


}
