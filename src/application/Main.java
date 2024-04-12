package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();

        System.out.println("========== TASKLIST ==========");

        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewTask(taskList);
                    break;
                case 2:
                    removeTask(taskList);
                    break;
                case 3:
                    showTasks(taskList);
                    break;
                case 0:
                    System.out.println("\nThanks for using my program!");
                    return;
                default:
                    System.err.println("\nInvalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.print("\n[1] Add new task\n[2] Remove a task\n[3] Show tasks\n[0] Exit\n--> ");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void addNewTask(ArrayList<String> taskList) {
        System.out.print("\nEnter a task to be added: ");
        sc.nextLine(); // Consume newline character
        String task = sc.nextLine();
        taskList.add(task);
        System.out.println("\nTask added successfully.");
    }

    private static void removeTask(ArrayList<String> taskList) {

        if (!taskList.isEmpty()) {
            System.out.print("\nEnter the task index to be removed: ");
            int taskIndex = sc.nextInt();

            if (taskIndex >= 1 && taskIndex <= taskList.size()) {
                taskList.remove(taskIndex - 1);
                System.out.println("Task removed successfully.");
            } else {
            System.err.println("Invalid index.\n");
            }
        } else {
            System.out.println("\nThere are no tasks.");
        }
    }

    private static void showTasks(ArrayList<String> taskList) {
        if (!taskList.isEmpty()) {
            System.out.println("\nTasks:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        } else {
            System.out.println("\nThere are no tasks.");
        }
    }
}
