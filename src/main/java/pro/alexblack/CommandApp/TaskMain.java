package pro.alexblack.commandapp;
import pro.alexblack.commandapp.commands.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
    Написать программу, реализующую свою командную строку с придуманными вами командами.
*/

public class TaskMain implements PathDelegate {

    private Path currentPath;

    public static void main(String[] args) throws IOException {
        new TaskMain().execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите комманду из списка комманд файла README.md.");
        System.out.println("Для выхда введите exit.");

        currentPath = Paths.get("").toAbsolutePath();

        CommandFactory factory = new CommandFactory(this);

        while (true) {
            System.out.println();
            System.out.print(currentPath.getFileName().toString() + " $> ");
            String[] arguments = scanner.nextLine().split(" ");
            if (arguments[0].equals("exit")) { break; }

            try {
                Command command = factory.getCommand(arguments[0]);
                command.execute(arguments);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Path getCurrentPath() {
        return currentPath;
    }

    @Override
    public void setCurrentPath(Path path) {
        currentPath = path;
    }
}
