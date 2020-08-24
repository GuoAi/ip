public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String name) {
        this.description = name;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
