package pro.alexblack.CommandApp;

public class NoSuchCommandException extends Exception {

    private String name;

    public NoSuchCommandException(String commandName) {
        this.name = commandName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return "Команды " + name + " не существет.";
    }
}
