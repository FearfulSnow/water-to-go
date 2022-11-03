package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), INVENTORY("inventory"), GIVE("give"), UNKNOWN("?");
    
    private final String commandString;

    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
