package pro.alexblack.commandapp.commands;

import pro.alexblack.commandapp.PathDelegate;
import pro.alexblack.commandapp.exceptions.NoSuchCommandException;

public class CommandFactory {

    private PathDelegate delegate;

    public CommandFactory(PathDelegate delegate) {
        this.delegate = delegate;
    }

    public Command getCommand(String commandName) throws NoSuchCommandException {
        Command result;

        switch (commandName) {
            case "ls": result = new DirectoryContents(); break;
            case "cd": result = new ChangeDirectory(); break;
            case "mv": result = new MoveFile(); break;
            case "cp": result = new CopyFile(); break;
            case "pwd": result = new CurrentDirectoryPath(); break;
            default: throw new NoSuchCommandException(commandName);
        }

        result.setDelegate(delegate);

        return result;
    }
}
