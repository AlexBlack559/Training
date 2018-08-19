package pro.alexblack.commands;

public class CommandFactory {

    private String command;

    CommandFactory(String command) {
        this.command = command;
    }

    Command getCommand() {
        Command result = null;

        switch (command) {
            case "mv": result = new Rename(); break;
            default: break;
        }

        return result;
    }
}
