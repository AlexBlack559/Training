package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChangeDirectory implements Command {

    @Override
    public Path execute(Path currentPath, String... args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Для этой комманды необходим 1 аргумент.");
        }

        Path destinationPath = currentPath.resolve(args[1]);
        if (Files.isDirectory(destinationPath)) {
            return destinationPath.normalize();
        } else {
            // Throw error?
            System.out.println("Такой директории не существует.");
            return currentPath;
        }
    }

    @Override
    public String getName() {
        return "cd";
    }
}
