public class Cell {
    final public static String EMPTY_STR = "|   "; //static allows us to access this without creating an object

    private String representation = EMPTY_STR;

    public String getRepresentation() {
        return representation;
    }
    public void setRepresentation(String representationIn) {
        representation = representationIn;
    }
}
