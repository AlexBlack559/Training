package pro.alexblack.CommandApp.commands;

import pro.alexblack.CommandApp.NoSuchCommandException;

public class CommandFactory {

    private String commandName;

    public CommandFactory(String commandName) {
        this.commandName = commandName;
    }

    public Command getCommandName() throws NoSuchCommandException {
        Command result;

        switch (commandName) {
            case "ls": result = new DirectoryContents(); break;
            case "cd": result = new ChangeDirectory(); break;
            case "mv": result = new MoveFile(); break;
            case "cp": result = new CopyFile(); break;
            case "pwd": result = new CurrentDirectoryPath(); break;
            default: throw new NoSuchCommandException(commandName);
        }

        return result;
    }
}
