package duke.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public Deadline(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
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
            return "[D][\u2714] " + this.description + " (by: " + this.deadline + ")";
        } else {
            return "[D][\u2718] " + this.description + " (by: " + this.deadline + ")";
        }
    }
}
