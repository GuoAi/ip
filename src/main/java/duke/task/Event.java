package duke.task;

public class Event extends Task {
    private String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public Event(String description, boolean isDone, String time) {
        super(description, isDone);
        this.time = time;
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
            return "[E][\u2714] " + this.description + " (at: " + this.time + ")";
        } else {
            return "[E][\u2718] " + this.description + " (at: " + this.time + ")";
        }
    }
}
