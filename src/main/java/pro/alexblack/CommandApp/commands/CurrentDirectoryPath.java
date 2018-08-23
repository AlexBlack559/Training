package pro.alexblack.CommandApp.commands;

import java.io.IOException;
import java.nio.file.Path;

public class CurrentDirectoryPath implements Command {

    @Override
    public Path execute(Path currentPath, String... args) throws IOException {
        System.out.println(currentPath.toString());
        return currentPath;
    }

    @Override
    public String getName() {
        return "pwd";
    }
}
