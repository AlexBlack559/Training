package pro.alexblack.commandapp.commands;

import pro.alexblack.commandapp.PathDelegate;

public abstract class Command {

    protected PathDelegate delegate;

    void setDelegate(PathDelegate delegate) {
        this.delegate = delegate;
    }

    public abstract void execute(String[] args) throws Exception;
}
