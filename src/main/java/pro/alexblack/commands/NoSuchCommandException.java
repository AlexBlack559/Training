package pro.alexblack.commands;

public class NoSuchCommandException extends Exception {

    private String name;

    NoSuchCommandException(String commandName) {
        this.name = commandName;
    }

    public String getName() {
        return name;
    }
}
