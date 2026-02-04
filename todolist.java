import java.util.ArrayList;
import java.util.Scanner;

public class todolist {
    public static void main(String[] args) {

        System.out.println("Welcome to your To-Do List!"); // Greet the user

        Scanner scanner = new Scanner(System.in); // Create a scanner for user input
        ArrayList<String> todoList = new ArrayList<>(); // Initialize the to-do list
        ArrayList<Boolean> completed = new ArrayList<>(); // Track completion status

        boolean running = true; // Flag to control the loop

        while (running) { // Show menu until user decides to exit
            System.out.println("\n=== To-Do List Menu ===");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Mark task as done");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            String choice = scanner.nextLine().trim(); // Get user choice

            switch (choice) {
                case "1": // Add a task
                    System.out.print("Enter the task to add: ");
                    String task = scanner.nextLine().trim();

                    if (task.isEmpty()) {
                        System.out.println("Task cannot be empty.");
                    } else {
                        todoList.add(task);
                        completed.add(false); // new task starts not completed
                        System.out.println("Added: " + task);
                    }
                    break;

                case "2": // View tasks
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks in your To-Do List.");
                    } else {
                        System.out.println("\nYour To-Do List:");
                        for (int i = 0; i < todoList.size(); i++) {
                            String status = completed.get(i) ? "[X]" : "[ ]";
                            System.out.println((i + 1) + ". " + status + " " + todoList.get(i));
                        }
                    }
                    break;

                case "3": // Remove a task
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        break;
                    }

                    System.out.println("Which task number would you like to remove?");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ". " + todoList.get(i));
                    }

                    System.out.print("Enter the task number to remove: ");
                    String numberText = scanner.nextLine().trim();

                    try {
                        int taskNumber = Integer.parseInt(numberText);
                        int index = taskNumber - 1;

                        if (index < 0 || index >= todoList.size()) {
                            System.out.println("Invalid task number.");
                        } else {
                            String removedTask = todoList.remove(index);
                            completed.remove(index); // keep lists in sync
                            System.out.println("Removed: " + removedTask);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number (like 1, 2, 3...).");
                    }
                    break;

                case "4": // Mark task as done
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks to mark.");
                        break;
                    }

                    System.out.println("Which task number do you want to mark as done?");
                    for (int i = 0; i < todoList.size(); i++) {
                        String status = completed.get(i) ? "[X]" : "[ ]";
                        System.out.println((i + 1) + ". " + status + " " + todoList.get(i));
                    }

                    System.out.print("Enter the task number: ");
                    String doneText = scanner.nextLine().trim();

                    try {
                        int taskNumber = Integer.parseInt(doneText);
                        int index = taskNumber - 1;

                        if (index < 0 || index >= todoList.size()) {  
                            System.out.println("Invalid task number.");
                        } else {
                            completed.set(index, true);
                            System.out.println("Task marked as done.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "5": // Exit
                    running = false;
                    System.out.println("Exiting the To-Do List. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}


