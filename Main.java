package To_Do_List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---To Do List---");
        while (true) {
            System.out.println("\n1. Add Task\n2. Delete Task\n3. Update Task\n4. View Tasks\n5. Exit");
            System.out.println("Choose an option:");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manager.addTask(scanner);
                    break;
                case 2:
                    manager.deleteTask(scanner);
                    break;
                case 3:
                    manager.updateTask(scanner);
                    break;
                case 4:
                    manager.viewTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
