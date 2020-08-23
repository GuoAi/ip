import java.util.ArrayList;
import java.util.Scanner;

 class Duke {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void echo(String command) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     " + command);
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void greet() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void exit() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void list() {
        System.out.println("    ____________________________________________________________");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + tasks.get(i).getName());
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void add(String task) {
        tasks.add(new Task(task));
        System.out.println("    ____________________________________________________________");
        System.out.println("     added: " + task);
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String command;
        greet();
        while (sc.hasNextLine()) {
            command = sc.nextLine();
            if (command.equals("bye")) {
                exit();
                return;
            } else if (command.equals("list")) {
                list();
            } else {
                add(command);
            }
        }
    }
}
