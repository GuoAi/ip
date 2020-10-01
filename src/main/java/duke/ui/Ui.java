package duke.ui;

import duke.DukeException;
import duke.common.Messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ui {

    private static Scanner sc = new Scanner(System.in);

    public static void showLine() {
        System.out.println(Messages.DIVIDER);
    }

    public static void dukePrint(String message) {
        showLine();
        System.out.println("     " + message);
        showLine();
        System.out.println();
    }

    public static void showWelcome() {
        System.out.println(Messages.LOGO);
        dukePrint("Hello! I'm Duke.\n     What can I do for you?");
    }

    public static void exit() {
        dukePrint(Messages.MESSAGE_GOODBYE);
    }

    public static void showLoadingError() {
        dukePrint(Messages.LOADING_ERROR);
    }

    public static String readCommand() {
        return sc.nextLine();
    }

    public static void showError(DukeException e) {
        dukePrint(e.getMessage());
    }

    public static String formatDateTime(String time) throws DateTimeParseException {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyy HH:mm");
        LocalDateTime formattedDateTime = LocalDateTime.parse(time, inputFormatter);
        String returnString = formattedDateTime.format(outputFormatter);
        return returnString;
    }
}
