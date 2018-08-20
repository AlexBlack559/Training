package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.Path;

public interface Command {

    void execute(Path currentPath, String... args) throws IOException;
    String getName();
}
