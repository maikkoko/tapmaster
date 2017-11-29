package ph.droidhero.tapmaster;

/**
 * Created by droidhero on 29/11/2017.
 */

public class PointCoordinates {

    private int xCoord;
    private int yCoord;

    public PointCoordinates(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    public int getX() {
        return xCoord;
    }

    public void setX(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public void setY(int yCoord) {
        this.yCoord = yCoord;
    }
}
