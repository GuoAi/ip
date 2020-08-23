import java.util.Scanner;

 class Duke {
    static Scanner sc = new Scanner(System.in);

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
            } else {
                 echo(command);
            }
        }
    }
}
