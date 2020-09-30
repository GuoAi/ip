package duke.commands;

import duke.task.TaskList;

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
