package pro.alexblack.commands;

public class CommandFactory {

    private String command;

    public CommandFactory(String command) {
        this.command = command;
    }

    public Command getCommand() throws NoSuchCommandException {
        Command result;

        switch (command) {
            case "mv": result = new Rename(); break;
            default: throw new NoSuchCommandException(command);
        }

        return result;
    }
}
