package duke;

import duke.commands.Command;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class Duke {

    private Storage storage;
    private TaskList tasks;

    public Duke(String filePath) {
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            Ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        Ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks);
                isExit = c.isExit();
            } catch (DukeException e) {
                Ui.showError(e);
            }
        }
        try {
            storage.save(tasks);
        } catch (DukeException e) {
            Ui.showError(e);
        }
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}