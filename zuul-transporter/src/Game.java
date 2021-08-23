import java.lang.String;
/**
 * Changes implemented since last update:
 * Removed createRoom method, created Scenario class instead
 * Main class now handles game start instead of Game method
 * Added comments on each method for brief description
 * @author Michael Kölling and David J. Barnes and Vanessa Watson
 * @version 19 May 2020
 */
public class Game {
    private Parser parser;
    private Room currentRoom;
    private Scenario scenario;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        scenario = new Scenario();
        currentRoom = scenario.getStartRoom();
        parser = new Parser();
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Hope you enjoyed the tour.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Zuul Mansion");
        System.out.println("Zuul Mansion is a newly built home, today's open house!");
        System.out.println("Take a look around.");
        System.out.println("Type 'help' if you need to.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)  //implementation of user commands
    {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("Try again...?");
            return false;
        }
        //todo features to add: pickup; drop; attack; (to be added) (med)
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("look")) {
            look();
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("observe")) {
            observe();
        }

        return wantToQuit;
    }

    /**
     * Print out some help information.
     */
    private void printHelp() {
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();


        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Prints information about the current location
     */
    private void printLocationInfo() {
        System.out.println(currentRoom.getDescription());
        System.out.print("Exits: ");
        currentRoom.getExitString();
    }

    /**
     * Prints information about a particular object within the world
     */
    private void look() {
        System.out.println(currentRoom.getDescription());
    }

    /**
     * Has character look at item
     */
    private void observe() {
        System.out.println("You observed the item");
    }
}
