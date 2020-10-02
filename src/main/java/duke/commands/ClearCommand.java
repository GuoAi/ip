package duke.commands;

import duke.task.TaskList;

/**
 * Clears all tasks in the task list.
 */
public class ClearCommand extends Command {

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.clearTask();
    }
}
