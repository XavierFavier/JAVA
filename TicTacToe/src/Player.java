public class Player {
    private String name; //for display purposes
    private String representation;

    public String getName() {
        return name;
    }
    public void setName(String nameIn) {
        name = nameIn;
    }

    public String getRepresentation() {
        return representation;
    }
    public void setRepresentation(String representationIn) {
        representation = "| " + representationIn + " ";
    }
}
