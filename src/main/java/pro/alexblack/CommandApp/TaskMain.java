package pro.alexblack.CommandApp;

import pro.alexblack.CommandApp.commands.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
    Написать программу, реализующую свою командную строку с придуманными вами командами.
*/

public class TaskMain {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите комманду из списка комманд файла README.md.");
        System.out.println("Для выхда введите exit.");

        Path currentPath = Paths.get("").toAbsolutePath();

        while (true) {
            System.out.println();
            System.out.print(currentPath.getFileName().toString() + " $> ");
            String[] arguments = scanner.nextLine().split(" ");
            if (arguments[0].equals("exit")) {
                break;
            }

            CommandFactory factory = new CommandFactory(arguments[0]);

            try {
                Command command = factory.getCommandName();
                currentPath = command.execute(currentPath, arguments);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
