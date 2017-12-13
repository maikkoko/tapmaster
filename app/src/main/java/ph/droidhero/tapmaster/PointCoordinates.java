package ph.droidhero.tapmaster;

/**
 * Created by droidhero on 29/11/2017.
 */

public class PointCoordinates {

    private float xCoord;
    private float yCoord;

    public PointCoordinates(Float xCoord, Float yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    public float getxCoord() {
        return xCoord;
    }

    public void setxCoord(Float xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(Float yCoord) {
        this.yCoord = yCoord;
    }

    public float getyCoord() {
        return yCoord;
    }
}
