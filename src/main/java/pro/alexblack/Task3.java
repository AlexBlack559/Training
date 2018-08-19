package pro.alexblack;

import pro.alexblack.commands.*;

import java.util.Scanner;

/*
    Написать программу, реализующую свою командную строку с придуманными вами командами.
*/

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите комманду, или help для получения информации о текущих коммандах");

        String[] commands = scanner.nextLine().split(" ");

    }
}
