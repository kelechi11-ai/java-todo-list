import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Lists to hold tasks and their completion status
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        // Control variable for the menu loop
        boolean running = true;

        // Show menu until user decides to exit
        while (running) {

            // Display the menu options
            System.out.println("\n=== TO-DO LIST MENU ===");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Mark task as done");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            // Read the user's choice
            String choice = scanner.nextLine().trim();

            // Perform action based on user choice
            switch (choice) {

                case "1":
                    // Add a task
                    System.out.print("Enter the task to add: ");
                    String task = scanner.nextLine().trim();

                    // Prevent empty tasks
                    if (task.isEmpty()) {
                        System.out.println("Task cannot be empty.");
                    } else {
                        tasks.add(task);          // Add the task to the list
                        completed.add(false);     // New tasks start as NOT completed
                        System.out.println("Added: " + task);
                    }
                    break;

                case "2":
                    // View tasks
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in your To-Do List.");
                    } else {
                        System.out.println("\nYour To-Do List:");
                        for (int i = 0; i < tasks.size(); i++) {
                            // Display [X] if completed, otherwise [ ]
                            String status = completed.get(i) ? "[X]" : "[ ]";
                            System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
                        }
                    }
                    break;

                case "3":
                    // Remove a task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        break;
                    }

                    // Display tasks with numbers
                    System.out.println("Which task number would you like to remove?");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }

                    // Read the task number to remove
                    System.out.print("Enter the task number to remove: ");
                    String numberText = scanner.nextLine().trim();

                    // Handle invalid input
                    try {
                        int taskNumber = Integer.parseInt(numberText);
                        int index = taskNumber - 1;

                        // Check if the number is valid
                        if (index < 0 || index >= tasks.size()) {
                            System.out.println("Invalid task number.");
                        } else {
                            // Remove the task and its completion status
                            String removedTask = tasks.remove(index);
                            completed.remove(index);
                            System.out.println("Removed: " + removedTask);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number (like 1, 2, 3...).");
                    }
                    break;

                case "4":
                    // Mark a task as done
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to mark.");
                        break;
                    }

                    // Display tasks with numbers and their status
                    System.out.println("Which task number do you want to mark as done?");
                    for (int i = 0; i < tasks.size(); i++) {
                        String status = completed.get(i) ? "[X]" : "[ ]";
                        System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
                    }

                    // Read the task number to mark as done
                    System.out.print("Enter the task number: ");
                    String doneText = scanner.nextLine().trim();

                    // Handle invalid input
                    try {
                        int taskNumber = Integer.parseInt(doneText);
                        int index = taskNumber - 1;

                        // Check if the number is valid
                        if (index < 0 || index >= tasks.size()) {
                            System.out.println("Invalid task number.");
                        } else {
                            completed.set(index, true); // Mark as completed
                            System.out.println("Task marked as done.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "5":
                    // Exit the program
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }

        // Close the scanner when done (cleanup)
        scanner.close();
    }
}
