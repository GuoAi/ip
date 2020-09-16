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
        dukePrint("     " + command);
    }

    public static void greet() {
        System.out.println(logo);
        dukePrint("     Hello! I'm duke.Duke\n     What can I do for you?");
    }

    public static void exit() {
        dukePrint("     Bye. Hope to see you again soon!");
    }

    public static void list() {
        String yesOrNo;
        String message = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (i == 0) {
                message = message + "     " + (i + 1) + "." + tasks.get(i).toString();
            } else {
                message = message + "\n     " + (i + 1) + "." + tasks.get(i).toString();
            }
        }
        dukePrint("     Here are the tasks in your list:\n" + message);
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
            dukePrint("     Got it. I've added this task:\n       " + task.toString() +"\n     Now you have " + tasks.size() + " tasks in the list.");
        } catch (DukeException e) {
            throwDukeException(e);
        }
    }

    public static void delete(int taskNum) {
        if (taskNum > tasks.size() || taskNum < 1) {
            dukePrint("     You do not have this task in the list.");
        } else {
            Task taskRemoved = tasks.get(taskNum - 1);
            dukePrint("     Noted. I've removed this task:\n       " + taskRemoved.toString() + "\n     Now you have " + (tasks.size() - 1) + " tasks in the list.");
            tasks.remove(taskNum - 1);
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
                    dukePrint("     Nice! I've marked this task as done:\n       [✓] " + tasks.get(taskNum).getDescription());
                } else if (Arrays.asList(commands).contains(command.split(" ")[0])) {
                    add(command);
                } else if (command.startsWith("delete")) {
                    String[] words = command.split(" ");
                    try {
                        int taskNum = Integer.valueOf(words[1]);
                        delete(taskNum);
                    } catch (NumberFormatException e) {
                        dukePrint("     Please input a valid task number.");
                    }
                } else {
                    throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                throwDukeException(e);
            }
        }
    }

    public static void throwDukeException(DukeException e) {
        dukePrint(e.toString());
    }

    public static void dukePrint(String message) {
        System.out.println("    ____________________________________________________________");
        System.out.println(message);
        System.out.println("    ____________________________________________________________");
        System.out.println();
    }

    public static void main(String[] args) {
        greet();
        execCommand();
    }
}
