/**
 * Zuul Mansion command words class
 *
 * There are no changes in this class.
 *
 * @author Michael Kölling and David J. Barnes and Vanessa Watson
 * @version 19 May 2020
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
            "go", "quit", "help", "look", "meditate", "sneak"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    /**
     * Print all valid commands to System.out.
     */
    public String getCommandList()
    {
        String c = "";

        for (String command : validCommands){
            c += command + ' ';
        }
        return c;
    }
}
