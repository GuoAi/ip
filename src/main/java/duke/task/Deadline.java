package duke.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[D][✓] " + this.description + " (by: " + this.deadline + ")";
        } else {
            return "[D][✗] " + this.description + " (by: " + this.deadline + ")";
        }
    }
}
