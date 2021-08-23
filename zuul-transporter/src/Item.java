/**
 * Item class creates the items for the game
 * @author Michael Kölling and David J. Barnes and Vanessa Watson
 * @version 19 May 2020
 */
public class Item {
    private String description;
    private int weight;

    /**
     * Create a new item with the given description and weight.
     * @param description
     * @param weight
     */
    public Item(String description, int weight){
        this.description = description;
        this.weight = weight;
    }

    /**
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
