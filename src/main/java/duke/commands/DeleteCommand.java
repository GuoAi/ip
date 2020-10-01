package duke.commands;

import duke.task.TaskList;

/**
 * Deletes a Task identified by its index in the task list.
 */
public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.deleteTask(index);
    }
}
