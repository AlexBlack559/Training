package pro.alexblack.commandapp.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile extends Command {

    @Override
    public void execute(String[] args) throws IOException {
        if (args.length != 3) {
            // Runtime exceptions does work for us in this case? (If we do not handle them usually)
            // Should we throw custom Exception?
            throw new IllegalArgumentException("Для этой комманды необходимо 2 аргумента.");
        }

        Path sourcePath = Paths.get(args[1]);
        Path destinationPath = Paths.get(args[2]);

        if (Files.exists(sourcePath)) {
            Files.copy(sourcePath, destinationPath);
        } else {
            throw new IllegalArgumentException("Такого пути не существует: " + sourcePath.toString());
        }
    }
}
