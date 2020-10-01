package duke.task;

import duke.common.Messages;
import duke.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        try {
            this.deadline = Ui.formatDateTime(deadline);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    public Deadline(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
        try {
            this.deadline = Ui.formatDateTime(deadline);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "D | 1 | " + description + " | " + deadline;
        } else {
            return "D | 0 | " + description + " | " + deadline;
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[D][Y] " + description + " (by: " + deadline + ")";
        } else {
            return "[D][N] " + description + " (by: " + deadline + ")";
        }
    }
}
