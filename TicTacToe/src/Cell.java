public class Cell {
    final public static String emptyStr = "|   "; //static allows us to access this without creating an object

    private String representation = emptyStr;

    public String getRepresentation() {
        return representation;
    }
    public void setRepresentation(String representationIn) {
        representation = representationIn;
    }
}
