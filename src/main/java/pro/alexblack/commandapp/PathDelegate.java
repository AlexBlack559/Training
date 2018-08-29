package pro.alexblack.commandapp;

import java.nio.file.Path;

public interface PathDelegate {

    Path getCurrentPath();
    void setCurrentPath(Path path);
}
