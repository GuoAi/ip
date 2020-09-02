import java.util.ArrayList;
import java.util.Scanner;

 class Duke {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();
    public String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

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
        String yesOrNo;
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i).toString());
        }
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void add(String command) {
        Task task;
        if (command.startsWith("todo")) {
            String todoString = command.substring(5);
            task = new Todo(todoString);
            tasks.add(task);
        } else if (command.startsWith("deadline")) {
            String deadlineString = command.substring(9);
            String[] deadlineStrings = deadlineString.split(" /by ");
            task = new Deadline(deadlineStrings[0], deadlineStrings[1]);
            tasks.add(task);
        } else if (command.startsWith("event")) {
            String eventString = command.substring(6);
            String[] eventStrings = eventString.split(" /at ");
            task = new Event(eventStrings[0], eventStrings[1]);
            tasks.add(task);
        } else {
            System.out.println("     Please enter valid commands");
            return ;
        }
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + task.toString());
        System.out.println("     Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void execCommand() {
        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                exit();
                return;
            } else if (command.equals("list")) {
                list();
            } else if (command.contains("done")) {
                String[] words = command.split(" ");
                int taskNum = Integer.valueOf(words[1]) - 1;
                tasks.get(taskNum).markAsDone();
                System.out.println("    ____________________________________________________________");
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       [✓] " + tasks.get(taskNum).getDescription());
                System.out.println("    ____________________________________________________________");
            } else {
                add(command);
            }
        }
    }

    public static void main(String[] args) {
        greet();
        execCommand();
    }
}
