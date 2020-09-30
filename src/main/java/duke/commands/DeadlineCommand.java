package duke.commands;

import duke.common.Messages;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeadlineCommand extends Command {

    private String description;
    private String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addDeadline(description, deadline);
    }
}
