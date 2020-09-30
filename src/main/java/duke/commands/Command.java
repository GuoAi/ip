package duke.commands;

import duke.task.TaskList;

public abstract class Command {

    public abstract boolean isExit();
    public abstract void execute(TaskList tasks);
}
