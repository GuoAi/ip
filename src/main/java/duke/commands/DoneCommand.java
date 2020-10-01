package duke.commands;

import duke.task.TaskList;

/**
 * Marks a Task, identified by its index in the task list, as done.
 */
public class DoneCommand extends Command {

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.markAsDone(index);
    }
}
