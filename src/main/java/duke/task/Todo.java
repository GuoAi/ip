package duke.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "T | 1 | " + description;
        } else {
            return "T | 0 | " + description;
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[T][✓] " + this.description;
        } else {
            return "[T][✗] " + this.description;
        }
    }
}
