package org.example.app.views;

import org.example.app.entities.User;

import java.util.Scanner;

public class UserCreateView {

    public User getData() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // Ввод и санитизация данных.
        // Санитизация через trim().

        String title = "Enter first name: ";
        System.out.print(title);
        user.setFirstName(scanner.nextLine().trim());

        title = "Enter last name: ";
        System.out.print(title);
        user.setLastName(scanner.nextLine().trim());

        title = "Enter phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        user.setPhone(scanner.nextLine().trim());

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        user.setEmail(scanner.nextLine().trim());

        return user;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
