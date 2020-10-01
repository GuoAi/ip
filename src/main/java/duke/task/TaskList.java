package duke.task;

import duke.common.Messages;
import duke.ui.Ui;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public void addTodo(String description) {
        Todo newTodo = new Todo(description);
        tasks.add(newTodo);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newTodo.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    public void addDeadline(String description, String deadline) {
        Deadline newDeadline = new Deadline(description, deadline);
        tasks.add(newDeadline);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newDeadline.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    public void addEvent(String description, String time) {
        Event newEvent = new Event(description, time);
        tasks.add(newEvent);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newEvent.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    public void deleteTask(int index) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            Task taskRemoved = tasks.get(index - 1);
            Ui.dukePrint(Messages.MESSAGE_DELETE + taskRemoved.toString() + Messages.MESSAGE_STATUS_FIRST + (tasks.size() - 1) + Messages.MESSAGE_STATUS_LAST);
            tasks.remove(index - 1);
        }
    }

    public void listTask() {
        String message = "";
        for (int i = 0; i < tasks.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + tasks.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST + message);
    }

    public void markAsDone(int index) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            tasks.get(index - 1).markAsDone();
            Ui.dukePrint(Messages.MESSAGE_DONE + tasks.get(index - 1).getDescription());
        }
    }

    public void findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        int count = 0;
        String message = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).description.toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(tasks.get(i));
                count++;
                message = message + "\n     " + count + "." + tasks.get(i).toString();
            }
        }
        if (!message.equals("")) {
            Ui.dukePrint(Messages.MESSAGE_FIND + message);
        } else {
            Ui.dukePrint(Messages.MESSAGE_NOT_FOUND);
        }
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }
}
