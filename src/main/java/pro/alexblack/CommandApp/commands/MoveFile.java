package pro.alexblack.commandapp.commands;

import java.nio.file.*;

public class MoveFile extends Command {

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 3) {
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
}
