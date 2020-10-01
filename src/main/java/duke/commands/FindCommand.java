package duke.commands;

import duke.task.TaskList;

/**
 * Finds and lists all tasks in the task list whose description contains the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.findTask(keyword);
    }
}
