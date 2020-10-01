package duke.commands;

import duke.common.Messages;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Adds an Event to the TaskList.
 */
public class EventCommand extends Command {

    private String description;
    private String time;

    public EventCommand(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addEvent(description, time);
    }
}
