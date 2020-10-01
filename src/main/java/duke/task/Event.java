package duke.task;

import duke.common.Messages;
import duke.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
        try {
            this.time = Ui.formatDateTime(time);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    public Event(String description, boolean isDone, String time) {
        super(description, isDone);
        this.time = time;
        try {
            this.time = Ui.formatDateTime(time);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "E | 1 | " + description + " | " + time;
        } else {
            return "E | 0 | " + description + " | " + time;
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
//            return "[E][\u2714] " + this.description + " (at: " + this.time + ")";
            return "[E][Y] " + this.description + " (at: " + this.time + ")";
        } else {
//            return "[E][\u2718] " + this.description + " (at: " + this.time + ")";
            return "[E][N] " + this.description + " (at: " + this.time + ")";
        }
    }
}
