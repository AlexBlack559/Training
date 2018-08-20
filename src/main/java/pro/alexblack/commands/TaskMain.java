package pro.alexblack.commands;

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

        System.out.println("Пожалуйста введите комманду, или help для получения информации о текущих коммандах");
        System.out.println("Для выхда наберите exit");

        Path currentPath = Paths.get("").toAbsolutePath();

        while (true) {
            System.out.println();
            System.out.print(currentPath.getFileName().toString() + " $> ");
            String[] arguments = scanner.next().split(" ");
            if (arguments[0].equals("exit")) {
                break;
            }

            CommandFactory factory = new CommandFactory(arguments[0]);

            try {
                Command command = factory.getCommand();
                command.execute(currentPath, arguments);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
