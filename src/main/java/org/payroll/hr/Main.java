package org.payroll.hr;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static list of users, acting as a database
    private static ArrayList<User> users = new ArrayList<>();


    private static AuthenticationService authenticationService = new AuthenticationService(users);
    private static boolean isRunning = true;

    /**
     * The entry point of the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        users.add(new User("test", "test"));
        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Displays the main menu to the user.
     */
    public static void showMenu() {
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        // Ask for user choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Handles the user's choice, mapping the menu options to the corresponding methods.
     * @param choice The user's choice.
     */
    public static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * Handles the log-in process, and the post-login operations.
     */
    public static void onLogIn() {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = authenticationService.logIn(username, password);
        if (user == null){
            System.out.println("Bad username or password");}else{
            System.out.println("Welcome, " + user.getUsername() + "!");
        ToDoList userList = new ToDoList(user);
        userList.run();
        }
    }

    /**
     * Handles the sign-up process.
     */
    public static void onSignUp() {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authenticationService.signUp(username, password);
        if (user != null){
        System.out.println("Your account is created, " + username);}else{
            System.out.println("Bad username or password");
        }
    }

    /**
     * Exits the application by setting the `isRunning` flag to false.
     */
    public static void onExit() {
        isRunning = false;
    }
}