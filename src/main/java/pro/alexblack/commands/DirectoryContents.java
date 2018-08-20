package pro.alexblack.commands;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DirectoryContents implements Command {

    @Override
    public void execute(Path currentPath, String... args) throws IOException {
        if (args.length != 1) {
            // Runtime exceptions does work for us in this case? (If we do not handle them usually)
            // Should we throw custom Exception?
            throw new IllegalArgumentException("У этой команды нет аргументов");
        }

        List<Path> paths = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentPath, "[!.]*")) {
            for (Path path : directoryStream) {
                paths.add(path);
            }
        }

        for (Path path : paths) {
            System.out.println(currentPath.relativize(path).toString());
        }
    }

    @Override
    public String getName() {
        return "ls";
    }

}
