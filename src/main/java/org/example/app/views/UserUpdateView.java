package org.example.app.views;

import org.example.app.entities.User;

import java.util.Scanner;


// Здесь применено решение для чтения String после int.
// scanner.nextLine();
//
// Scanner не видит ввод в виде нескольких строк, как мы.
// Вместо этого он получает «поток символов».
// Когда вызываем nextInt, он считывает символы, пока не дойдет
// до нецифры.
// Например, int id = 2, String phone = 555 123-4567.
// Scanner читает  2\n555 123-4567\n
//
// nextInt возвращает 2.
// Затем отображается текст-предложение ввести телефон,
// и вызывается nextLine, который считывает символы,
// пока не дойдет до новой строки.
// Но так как следующий символ уже является новой строкой,
// nextLine возвращает пустую строку "".
//
// Чтобы решить эту проблему, нужна дополнительная nextLine
// после nextInt.
public class UserUpdateView {

    public User doInputs() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String title = "Enter user's ID: ";
        System.out.print(title);
        user.setId(scanner.nextInt());

        // Fix String после int.
        scanner.nextLine();

        title = "Enter new phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        user.setPhone(scanner.nextLine().trim());

        return user;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
