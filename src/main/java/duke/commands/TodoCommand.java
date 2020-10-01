package duke.commands;

import duke.common.Messages;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Adds a Todo to the TaskList.
 */
public class TodoCommand extends Command {

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addTodo(description);
    }
}
