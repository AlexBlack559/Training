package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.*;

public class Move implements Command {

    @Override
    public void execute(Path currentPath, String... args) throws IOException {
        if (args.length != 3) {
            // Runtime exceptions does work for us in this case? (If we do not handle them usually)
            // Should we throw custom Exception?
            throw new IllegalArgumentException("Для этой комманды необходимо 2 аргумента.");
        }

        Path sourcePath = Paths.get(args[1]);
        Path destinationPath = Paths.get(args[2]);

        if (Files.exists(sourcePath)) {
            Files.move(sourcePath, destinationPath);
        } else {
            throw new IllegalArgumentException("Такого пути не существует: " + sourcePath.toString());
        }
    }

    @Override
    public String getName() {
        return "mv";
    }
}
