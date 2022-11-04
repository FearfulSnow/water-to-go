package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), INVENTORY("inventory"), GIVE("give"), REMOVE("remove"), UNKNOWN("?"), ACCEPTTASK("accept"), COMPLETETASK("completetask");
    
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
