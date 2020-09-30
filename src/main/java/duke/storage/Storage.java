package duke.storage;

import duke.DukeException;
import duke.common.Messages;
import duke.common.Utils;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws DukeException {
        File file = new File(filePath);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        ArrayList<Task> tasks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] taskParts = line.split(" \\| ");
            switch (taskParts[0].trim()) {
            case "T":
                tasks.add(new Todo(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim())));
                break;
            case "E":
                tasks.add(new Event(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim()), taskParts[3].trim()));
                break;
            case "D":
                tasks.add(new Deadline(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim()), taskParts[3].trim()));
                break;
            }
        }
        return tasks;
    }

    public void save(TaskList tasks) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String taskString = "";
        for (int i = 0; i < tasks.size(); i++) {
            taskString = taskString + tasks.get(i).toFile() + "\n";
        }
        try {
            fw.write(taskString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }
}
