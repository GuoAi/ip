package duke.task;

import duke.common.Messages;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs a task list with the given tasks.
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructs an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return an ArrayList of {@code Task}
     */
    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    /**
     * Adds a todo task to the task list.
     *
     * @param description the description of the todo task
     */
    public void addTodo(String description) {
        Todo newTodo = new Todo(description);
        tasks.add(newTodo);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newTodo.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    /**
     * Adds a deadline task to the task list.
     *
     * @param description the description of the deadline task
     * @param deadline the deadline of the task
     */
    public void addDeadline(String description, String deadline) {
        Deadline newDeadline = new Deadline(description, deadline);
        tasks.add(newDeadline);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newDeadline.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    /**
     * Adds an event task to the task list.
     *
     * @param description the description of the event task
     * @param time the time of the task to be done
     */
    public void addEvent(String description, String time) {
        Event newEvent = new Event(description, time);
        tasks.add(newEvent);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newEvent.toString() + Messages.MESSAGE_STATUS_FIRST + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    /**
     * Deletes a task from the list, identified by the index of the task in the task list.
     *
     * @param index the index of the task in the task list
     */
    public void deleteTask(int index) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            Task taskRemoved = tasks.get(index - 1);
            Ui.dukePrint(Messages.MESSAGE_DELETE + taskRemoved.toString() + Messages.MESSAGE_STATUS_FIRST + (tasks.size() - 1) + Messages.MESSAGE_STATUS_LAST);
            tasks.remove(index - 1);
        }
    }

    /**
     * Lists all the tasks in the task list.
     */
    public void listTask() {
        String message = "";
        for (int i = 0; i < tasks.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + tasks.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST + message);
    }

    /**
     * Marks the task, identified by the index of the task in the task list, as done.
     *
     * @param index the index of the task in the task list
     */
    public void markAsDone(int index) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            tasks.get(index - 1).markAsDone();
            Ui.dukePrint(Messages.MESSAGE_DONE + tasks.get(index - 1).getDescription());
        }
    }

    /**
     * Finds and lists all tasks in the task list whose description contains the argument keywords.
     * Keyword matching is case-insensitive.
     *
     * @param keyword the keyword to be searched in the task list
     */
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

    /**
     * @return the size of the task list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Retrieves a task using the given index.
     *
     * @param index the index of the task to be retrieved
     * @return the task in the task list at the given index
     */
    public Task get(int index) {
        return tasks.get(index);
    }
}
