package pro.alexblack.commandapp.commands;

import pro.alexblack.commandapp.exceptions.NoSuchDirectoryException;

import java.nio.file.Files;
import java.nio.file.Path;

public class ChangeDirectory extends Command {

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Для этой комманды необходим 1 аргумент.");
        }

        Path destinationPath = delegate.getCurrentPath().resolve(args[1]).normalize();
        if (Files.isDirectory(destinationPath)) {
            delegate.setCurrentPath(destinationPath);
        } else {
            throw new NoSuchDirectoryException("Такой директории не существует.");
        }
    }
}
