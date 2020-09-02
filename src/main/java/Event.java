public class Event extends Task {
    private String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[E][✓] " + this.description + " (at: " + this.time + ")";
        } else {
            return "[E][✗] " + this.description + " (at: " + this.time + ")";
        }
    }
}
