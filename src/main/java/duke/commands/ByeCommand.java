package duke.commands;

import duke.common.Messages;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Terminates the program.
 */

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks) {
        Ui.exit();
    }
}
