package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.Path;

public interface Command {

    Path execute(Path currentPath, String... args) throws IOException;
    String getName();
}
