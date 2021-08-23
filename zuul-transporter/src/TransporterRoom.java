/**
 * @author Michael Kölling and David J. Barnes and Vanessa Watson
 * @version 19 May 2020
 */
public class TransporterRoom extends Room {
    private Scenario scene;

    /**
     * Random teleporter
     */
    public TransporterRoom(String description, Scenario scene)
    {
        super(description);
        this.scene = scene;
    }

    /**
     * Describe the exits
     */
    public String getExitString()
    {
        return "You cannot really see the exits...";
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction)
    {
        return scene.getRandomRoom();
    }
}
