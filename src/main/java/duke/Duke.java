package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

 class Duke {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();
    public static String logo = "    ____        _        \n"
            + "    |  _ \\ _   _| | _____ \n"
            + "    | | | | | | | |/ / _ \\\n"
            + "    | |_| | |_| |   <  __/\n"
            + "    |____/ \\__,_|_|\\_\\___|\n";
    private static String[] commands = {"todo", "event", "deadline"};

    public static void echo(String command) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     " + command);
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void greet() {
        System.out.println("    ____________________________________________________________");
        System.out.println(logo);
        System.out.println("     Hello! I'm duke.Duke");
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
        try {
            if (command.startsWith("todo")) {
                String todoString = "";
                try {
                    todoString = command.substring(5);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new DukeException("     ☹ OOPS!!! The description of a todo cannot be empty.");
                }
                task = new Todo(todoString);
                tasks.add(task);
            } else if (command.startsWith("deadline")) {
                String deadlineString = "";
                try {
                    deadlineString = command.substring(9);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new DukeException("     ☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                String[] deadlineStrings = deadlineString.split(" /by ");
                try {
                    task = new Deadline(deadlineStrings[0], deadlineStrings[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("     Please enter your deadline in the correct format.\n     Example: deadline return book /by Sunday");
                }
                tasks.add(task);
            } else if (command.startsWith("event")) {
                String eventString = "";
                try {
                    eventString = command.substring(6);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new DukeException("     ☹ OOPS!!! The description of an event cannot be empty.");
                }
                String[] eventStrings = eventString.split(" /at ");
                try {
                    task = new Event(eventStrings[0], eventStrings[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("     Please enter your deadline in the correct format.\n     Example: event project meeting /at Mon 2-4pm");
                }
                tasks.add(task);
            } else {
                System.out.println("     Please enter valid commands");
                return;
            }
            System.out.println("    ____________________________________________________________");
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + task.toString());
            System.out.println("     Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
            System.out.println();
        } catch (DukeException e) {
            throwDukeException(e);
        }
    }

    public static void execCommand() {
        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            try {
                if (command.equals("bye")) {
                    exit();
                    return;
                } else if (command.equals("list")) {
                    list();
                } else if (command.contains("done")) {
                    String[] words = command.split(" ");
                    int taskNum = Integer.valueOf(words[1]) - 1;
                    if (taskNum >= tasks.size()) {
                        throw new DukeException("     ☹ OOPS!!! There is no such task in your list");
                    }
                    tasks.get(taskNum).markAsDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       [✓] " + tasks.get(taskNum).getDescription());
                    System.out.println("    ____________________________________________________________");
                    System.out.println();
                } else if (Arrays.asList(commands).contains(command.split(" ")[0])) {
                    add(command);
                } else {
                    throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                throwDukeException(e);
            }
        }
    }

    public static void throwDukeException(DukeException e) {
        System.out.println("    ____________________________________________________________");
        System.out.println(e.toString());
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void main(String[] args) {
        greet();
        execCommand();
    }
}
