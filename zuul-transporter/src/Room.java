import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

/**
 * Room class contains the hashmap for each given room to facilitate room creation
 * Room class also contains item information
 * @author Michael Kölling and David J. Barnes and Vanessa Watson
 * @version 19 May 2020
 */
public class Room
{
    private String description;
    public HashMap<String, Room> exits;
    private HashSet items;

    /**
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        items = new HashSet();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor Where the exit leads.
     */
    public void setExits(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @param direction The exit's direction.
     * @return the room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    /**
     * Return a string describing the items in the room, for example
     * "Items: beer wine".
     */
    public String getItemString()
    {
        String returnString = "Items:";
        for(Iterator iter = items.iterator(); iter.hasNext(); )
            returnString += " " + ((Item) iter.next()).getDescription();

        return returnString;
    }
    /**
     * Return a description of the room's exits,
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }
    /**Return a long description of this room
     * @return A description of the room, including exits
     */
    public String getDescription(){
        return "You are " + description + ".\n" + getExitString() + ".\n" + getItemString();
    }
    /**
     * Puts an item into this room.
     */
    public void addItem(Item item) {
        items.add(item);
    }
}