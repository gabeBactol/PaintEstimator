package gbactol.cs134.miracosta.edu.Model;


/**
 * InteriorRoom java class calculates the amount of pain needed to re-coat a room.
 *
 * @author Gabriel Bactol
 * @version 1.0
 */
public class InteriorRoom
{
    //fields: private
    private int mDoors;
    private int mWindows;

    private double mWidth;
    private double mHeight;
    private int mLength;

    /**
     * Standard door area (3 feet by 7 feet)
     */
    public static final double WINDOW_AREA = 21.0;

    public static final double DOOR_AREA = 16.0;

    public static final double SQ_FEET_PER_GALLON = 275.0;

    public InteriorRoom()
    {
        mDoors = 0;
        mWindows = 0;
        mWidth = 0.0;
        mHeight = 0.0;
        mLength = 0;
    }

    /**
     * A full constructor that assigns values to variables of the class based on the variables passed in.
     * Instantiates a new <code>InteriorRoom</code> privided with the number of doors, windows, and its dimensions: width,
     * height, and length
     * @param doors The number of doors in the room
     * @param windows The number of windows in the room
     * @param width The width of the room
     * @param height The height of the room
     * @param length The length of the room
     */
    public InteriorRoom(int doors, int windows, double width, double height, int length) {
        mDoors = doors;
        mWindows = windows;
        mWidth = width;
        mHeight = height;
        mLength = length;
    }

    public int getDoors() {
        return mDoors;
    }

    public void setDoors(int doors) {
        mDoors = doors;
    }

    public int getWindows() {
        return mWindows;
    }

    public void setWindows(int windows) {
        mWindows = windows;
    }

    public double getWidth() {
        return mWidth;
    }

    public void setWidth(double width) {
        mWidth = width;
    }

    public double getHeight() {
        return mHeight;
    }

    public void setHeight(double height) {
        mHeight = height;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public static double getWindowArea() {
        return WINDOW_AREA;
    }

    public static double getDoorArea() {
        return DOOR_AREA;
    }

    public static double getSqFeetPerGallon() {
        return SQ_FEET_PER_GALLON;
    }

    @Override
    public String toString() {
        return "InteriorRoom{" +
                "mDoors=" + mDoors +
                ", mWindows=" + mWindows +
                ", mWidth=" + mWidth +
                ", mHeight=" + mHeight +
                ", mLength=" + mLength +
                '}';
    }

    public double doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public double totalSurfaceArea()
    {
        double totalSurfaceArea = 2.0 * mWidth * mHeight + 2.0 * mLength * mHeight;
        if(totalSurfaceArea < 0)
        {
            return 0.0;
        }
        else
        {
            return totalSurfaceArea;
        }
    }

    public double wallSurfaceArea()
    {
        return totalSurfaceArea() - doorAndWindowArea();
    }

    public double gallonsofPaintRequired()
    {
        double gallons = wallSurfaceArea(); //SQ_FT_PER_GALLON;
        if(gallons < 0)
        {
            return 0.0;
        }
        else
        {

            return gallons;
        }
    }
}
