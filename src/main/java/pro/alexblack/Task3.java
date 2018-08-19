package pro.alexblack;

import pro.alexblack.commands.*;

import java.io.IOException;
import java.util.Scanner;

/*
    Написать программу, реализующую свою командную строку с придуманными вами командами.
*/

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите комманду, или help для получения информации о текущих коммандах");
        System.out.println("Для выхда наберите exit");

        while (true) {
            String[] arguments = scanner.nextLine().split(" ");
            if (arguments[0].equals("exit")) {
                break;
            }

            CommandFactory factory = new CommandFactory(arguments[0]);

            try {
                Command command = factory.getCommand();
                command.execute(arguments);
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            } catch (NoSuchCommandException e) {
                System.out.println("Такой комманды не существет");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
