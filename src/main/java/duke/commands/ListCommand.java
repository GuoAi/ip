package duke.commands;

import duke.task.TaskList;

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
