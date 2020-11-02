
/**
 * The corner/edge class for the rubik's cube.  Needs to store 3 colours as well as their axes so that when the cube is rendered
 * the program knows which direction the colours are pointing. This is done by storing the colours as the axes.
 * This doesn't result in issues with the axes potentially meaning two different things since the direction of exactly
 * which colour is clear based on the position of the corner in the cube.  To make the piece an edge, just set one colour
 * to null and store it in the correct position
 * @author Shaemus Melvin
 *
 */
public class CornerEdge extends CubePiece {
    Colour x;
    Colour y;
    Colour z;

    public CornerEdge(Colour x, Colour y, Colour z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void swapXY() {
        Colour holder = x;
        x = y;
        y = holder;
    }

    public void swapXZ() {
        Colour holder = x;
        x = z;
        z = holder;

    }

    public void swapYZ() {
        Colour holder = y;
        y = z;
        z = holder;
    }

    public Colour getX() {
        return x;
    }

    public Colour getY() {
        return y;
    }

    public Colour getZ() {
        return z;
    }
}
