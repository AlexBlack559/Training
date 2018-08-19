package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.*;

public class Rename implements Command {

    @Override
    public void execute(String... args) throws IOException {
        if (args.length != 3) {
            // Runtime exceptions does work for us in this case? (If we do not handle them usually)
            // Should we throw custom Exception?
            throw new IllegalArgumentException("Two arguments needed");
        }

        Path sourcePath = Paths.get(args[0]);
        Path destinationPath = Paths.get(args[1]);

        if (Files.exists(sourcePath)) {
            Files.move(sourcePath, destinationPath);
        }
    }

    @Override
    public String getName() {
        return "mv";
    }

    @Override
    public String getDescription() {
        return "Renames file or folder.";
    }
}
