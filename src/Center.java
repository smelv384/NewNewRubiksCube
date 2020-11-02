/**
 * This is an extremely simple class.  Since the axis is stored in the cube object as the instance of the center,
 * it's not necessary to store the axis of the piece, and since there's only one colour, it just needs to be one simple method.
 * Since the colour is never modified, setters aren't needed and the colour variable can be final
 * @author Shaemus Melvin
 *
 */
public class Center extends CubePiece {
    private final Colour centerColour;

    public Center(Colour centerColour) {
        this.centerColour = centerColour;
    }

    public Colour getColour() {
        return centerColour;
    }
}
