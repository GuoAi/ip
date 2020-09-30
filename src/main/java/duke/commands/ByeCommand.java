package duke.commands;

import duke.common.Messages;
import duke.task.TaskList;
import duke.ui.Ui;

public class ByeCommand extends Command {

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks) {
        Ui.exit();
    }
}
