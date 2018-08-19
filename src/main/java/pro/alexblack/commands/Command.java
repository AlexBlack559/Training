package pro.alexblack.commands;

import java.io.IOException;

public interface Command {

    void execute(String... args) throws IOException;
    String getName();
    String getDescription();
}
