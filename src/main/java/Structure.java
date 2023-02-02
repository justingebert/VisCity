public class Structure {
    public int width;
    public int height;
    public int xCoordinate;
    public int yCoordinate;

    public String backgroundColor;


    /**
     * init strucutre
     * @param width width of the structure
     * @param height height of the structure
     * @param xCoordinate upper left corner x coordinate
     * @param yCoordinate upper left corner y coordinate
     * @param backgroundColor color of the structure defining the type
     */
    public Structure(int width, int height, int xCoordinate, int yCoordinate, String backgroundColor) {
        this.width = width;
        this.height = height;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.backgroundColor = backgroundColor;
    }
}

