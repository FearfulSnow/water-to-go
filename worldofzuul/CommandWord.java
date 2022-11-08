package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), INVENTORY("inventory"), GIVE("give"), REMOVE("remove"), UNKNOWN("?"), ACCEPTTASK("accept"), COMPLETETASK("complete"), TASK("task"), FILL("fill"), SEARCH("search");
    
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
