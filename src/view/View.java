package view;

import java.util.Scanner;

import service.Function;

public class View {
    private static final Function function = new Function();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Welcome to YUHBANK");
            System.out.println("======================");
            System.out.println("1. Login\n2.Register");
            System.out.print("Your choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    String username = enterLoginInformation();
                    if (username != null) {
                        boolean flag = true;
                        while (flag) {
                            System.out.println("1.transfer\n2. view information\n3. change pass word");
                            int choose = scanner.nextInt();
                            scanner.nextLine();
                            switch (choose) {
                                case 1 -> enterTransferInformation(username);
                                case 2 -> viewInformation(username);
                                case 3 -> enterChangePassWordInformation(username);
                                default -> flag = false;
                            }
                        }
                    }
                }
                case 2 -> enterRegisterInformation();
                default -> run = false;
            }
        }
    }

    public static String enterLoginInformation() {
        System.out.println("-Longin-");
        System.out.print("Enter user name: ");
        String username = scanner.nextLine();
        System.out.print("Enter pass word: ");
        String password = scanner.nextLine();
        if (function.login(username, password)) {
            return username;
        }
        return null;
    }

    public static void enterRegisterInformation() {
        System.out.println("-Register-");
        System.out.print("Enter user name: ");
        String username = scanner.nextLine();
        System.out.print("Enter pass word: ");
        String password = scanner.nextLine();
        System.out.print("Enter balance: ");
        float balance = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sex: ");
        String sex = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        function.register(username, password, balance, fullName, age, sex, address);
    }

    public static void enterTransferInformation(String username) {
        System.out.print("Enter Recipient Account: ");
        String recipientAccount = scanner.nextLine();
        System.out.print("Enter amount of money: ");
        float amountOfMoney = scanner.nextFloat();
        scanner.nextLine();
        function.transfer(username, recipientAccount, amountOfMoney);
    }

    public static void viewInformation(String username) {
        System.out.println(function.viewAccountInformation(username).toString());
    }

    public static void enterChangePassWordInformation(String username) {
        System.out.print("Enter old pass word: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new pass word: ");
        String newPassword = scanner.nextLine();
        function.changePassWord(username, oldPassword, newPassword);
    }
}
