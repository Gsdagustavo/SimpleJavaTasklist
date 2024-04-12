package application;

import util.Tasklist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ArrayList<Tasklist> tasklist = new ArrayList<Tasklist>();

        boolean exit = false;

        System.out.println("========== TASKLIST ==========");

        while (!exit) {
            System.out.print("\n[1] Add new task\n[2] Remove a task\n[3] Show tasks\n[0] Exit\n--> ");
            int esc = 0;

            try {
                esc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("An error has occurred: " + e);
            }

            switch (esc) {
                case 1:
                    addNewTask(tasklist);
                    break;

                case 2:
                    removeTask(tasklist);
                    break;

                case 3:
                    showTasks(tasklist);
                    break;

                case 0:
                    exit = true;
                    break;
                default:
                    System.err.println("\nInvalid option.");
            }
        }

        System.out.println("\nThanks for using my program!");
    }

    public static ArrayList<Tasklist> addNewTask(ArrayList<Tasklist> tasklistArrayList) {
        System.out.print("\nEnter a task to be added: ");
        String task = sc.nextLine();

        int index = 0;

        for (Tasklist tsk : tasklistArrayList) {
            index++;
        }

        tasklistArrayList.add(new Tasklist(task, index));

        System.out.println("\nTask added succesfully.");
        return tasklistArrayList;
    }

    public static ArrayList<Tasklist> removeTask(ArrayList<Tasklist> tasklistArrayList) {
        System.out.println("\nEnter the task index to be removed: ");
        int taskIndex = 0;

        if (!tasklistArrayList.isEmpty()) {
            try {
                taskIndex = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("An error has occurred: " + e);
            }

            try {
                tasklistArrayList.remove(taskIndex);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nInvalid index.");
                return tasklistArrayList;
            }

            System.out.println("Task removed successfully.");
            return tasklistArrayList;
        } else {
            System.out.println("\nThere are no tasks.");
            return tasklistArrayList;
        }
    }

    public static void showTasks(ArrayList<Tasklist> tasklistArrayList) {
        int i = 0;
        System.out.println();

        if (tasklistArrayList.isEmpty()) {
            System.out.println("There are no tasks.");
        } else {
            for (Tasklist task : tasklistArrayList) {
                System.out.println(task);
            }
        }
    }
}
