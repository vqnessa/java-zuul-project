import java.util.ArrayList;
import java.util.Random;

/**
 * Scenario class
 *
 * @author Cara Tang and Vanessa Watson
 * @version 19 May 2020
 */

/**
 * Create all the rooms and link their exits together.
 */
public class Scenario
{
    private ArrayList<Room> rooms;     // List of all rooms in the game
    private Room startRoom;
    private Random random;

    /**
     * Create a complete scenario (with all rooms).
     */
    public Scenario() {
        Room inside, kitchen, bedroom, bathroom, diningRoom, theater, transporter;

        // create the rooms
        inside = new Room("in the main common room of the Mansion");
        kitchen = new Room("in the kitchen.");
        bedroom = new Room("in the master bedroom.");
        bathroom = new Room("in the master bathroom.");
        diningRoom = new Room("in the dining room.");
        theater = new Room("in the theater.");
        transporter = new TransporterRoom("in the secret transport room...", this);

        kitchen.addItem(new Item("Fridge", 300));
        kitchen.addItem(new Item("Microwave", 20));
        inside.addItem(new Item("Coat rack", 7));
        bedroom.addItem(new Item("King bed", 55));
        bathroom.addItem(new Item("Toilet", 10));
        diningRoom.addItem(new Item("Chair", 5));
        theater.addItem(new Item("Projector", 2));

        // initialise room exits
        inside.setExits("north", transporter);
        inside.setExits("east", bedroom);
        inside.setExits("south", kitchen);

        transporter.setExits("south", inside);

        kitchen.setExits("east", diningRoom);
        kitchen.setExits("north", inside);

        bedroom.setExits("west", inside);
        bedroom.setExits("east", bathroom);
        bedroom.setExits("south", theater);

        bathroom.setExits("west", bedroom);

        diningRoom.setExits("west", kitchen);
        diningRoom.setExits("north", theater);

        theater.setExits("south", diningRoom);
        theater.setExits("north", bedroom);

        // Set the start room
        startRoom = inside;

        rooms = new ArrayList();
        rooms.add(inside);
        rooms.add(kitchen);
        rooms.add(bedroom);
        rooms.add(bathroom);
        rooms.add(diningRoom);
        rooms.add(theater);
        rooms.add(transporter);

        random = new Random();
    }

    /**
     * Return the room where players start the game.
     */
    public Room getStartRoom(){
        return startRoom;
    }

    /**
     * Return a random room in this game.
     */
    public Room getRandomRoom(){
        return (Room)rooms.get(random.nextInt(rooms.size()));
    }
}
