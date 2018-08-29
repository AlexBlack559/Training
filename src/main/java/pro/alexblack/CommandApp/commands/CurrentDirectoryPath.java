package pro.alexblack.commandapp.commands;

import java.io.IOException;
import java.nio.file.Path;

public class CurrentDirectoryPath extends Command {

    @Override
    public void execute(String[] args) {
        System.out.println(delegate.getCurrentPath().toString());
    }
}
