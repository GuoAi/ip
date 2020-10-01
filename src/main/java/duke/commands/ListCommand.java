package duke.commands;

import duke.task.TaskList;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.listTask();
    }
}
