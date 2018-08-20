package pro.alexblack.commands;

public class CommandFactory {

    private String command;

    public CommandFactory(String command) {
        this.command = command;
    }

    public Command getCommand() throws NoSuchCommandException {
        Command result;

        switch (command) {
            case "ls": result = new DirectoryContents(); break;
            case "mv": result = new Move(); break;
            default: throw new NoSuchCommandException(command);
        }

        return result;
    }
}
