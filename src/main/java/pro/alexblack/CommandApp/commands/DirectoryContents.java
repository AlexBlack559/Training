package pro.alexblack.commandapp.commands;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DirectoryContents extends Command {

    @Override
    public void execute(String[] args) throws IOException {
        if (args.length != 1) {
            // Runtime exceptions does work for us in this case? (If we do not handle them usually)
            // Should we throw custom Exception?
            throw new IllegalArgumentException("У этой команды нет аргументов");
        }

        List<Path> paths = new ArrayList<>();
        Path currentPath = delegate.getCurrentPath();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentPath, "[!.]*")) {
            for (Path path : directoryStream) {
                paths.add(path);
            }
        }

        for (Path path : paths) {
            System.out.println(currentPath.relativize(path).toString());
        }
    }

}
