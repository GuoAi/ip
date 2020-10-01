# User Guide  
  
## Quick Start  
1. Ensure you have Java `11` or above installed in your Computer.  
2. Download the latest `duke.jar`.  
3. Copy the file to the folder you want to use as the home folder for your Duke.  
4. Use your terminal or command prompt to go to the working directory of your Duke.  
5. Type the command `java -jar duke.jar` to start the program.  
6. Type the command in the command box and press Enter to execute it. e.g. typing `list` and pressing Enter will list all your tasks.  
Some example commands you can try:  
    * `list`: Lists all tasks  
    * `todo read book`: Adds a `Todo` task with description `read book` to the task list  
    * `delete 3`: Deletes the 3rd task shown in the current list.  
    * `bye`: Exits the app.  
7. Refer to the Features below for details of each command.  
  
  
## Features   
  
### Adding a Todo Task: `todo`  
Adds a Todo task to the task list. 
     
Format: `todo DESCRIPTION`  
  
Examples:  
* `todo read book`  
* `todo join sports club`  

### Adding a Deadline Task: `deadline`  
Adds a Deadline task to the task list. 
   
Format: `deadline DESCRIPTION /by DEADLINE`
    
Examples:  
* `deadline return book /by June 6th`  
* `deadline return book /by 2021-06-06 12:00`  

### Adding an Event Task: `event`  
Adds an Event task to the task list.  
  
Format: `event DESCRIPTION /at TIME` 
   
Examples:  
* `event project meeting /at Aug 6th 2-4pm`  
* `event project meeting /at 2021-08-06 14:00`  
  
### Deleting a Task: `delete`  
Deletes the specified task from the task list  
  
Format: `delete INDEX`  
* Deletes the person at the specified `INDEX`.  
* The index refers to the index number shown in the displayed task list.  
* The index **must be a positive integer** 1, 2, 3, ...    
  
Examples:  
* `list` followed by `delete 2` deletes the 2nd task in the task list.  
  
### Listing All Tasks: `list`  
Shows a list of all tasks in the task list.  
  
Format: `list`  

### Locating Tasks by Description: `find`  
Finds tasks whose descriptions contain the given keywords.  
  
Format: `find KEYWORDS`
* The search is case-insensitive. e.g. `Book` will match `book`
* The keywords need to match exactly, i.e. the entire keyword string needs to be matched.
* Only the description is searched.
* All tasks matching the keyword string will be returned.  
  
Examples:  
* `find book` returns all tasks whose descriptions contain string `book`, e.g.  
Here is a sample return by `find book` command  
    \___________________________________________________\_________  
     Here are the matching tasks in your list:  
     1.[T][Y] read book  
     2.[D][Y] return book (by: June 6th)  
     3.[T][N] borrow book  
    \___________________________________________________\_________  

### Marking a Task as Done: `done`  
Marks the specified person as done.  
  
Format: `done INDEX`  
* Marks the task at the specified `INDEX` as done.  
* The index refers to the index number shown in the task list.  
* The index **must be a positive integer** 1, 2, 3, ...  
  
Examples:  
* `list` followed by `done 2` marks the 2nd task in the task list as done.

### Exiting the Program and Saving TaskList to File: `bye`  
Exits the program. TaskList data are saved into a file automatically after the program is terminated.  
There is no need to save manually.  
  
Format: `bye`  
  
  
## Command Summary  
| **Action** | **Format, Examples** |  
| ---------- | -------------------- |  
| **Todo** | `todo DESCRIPTION` <br> e.g. `todo read book` |  
| **Deadline** | `deadline DESCRIPTION /by DEADLINE` <br> e.g. `deadline return book /by June 6th`, <br> `deadline return book /by 2021-06-06 12:00` |  
| **Event** | `event DESCRIPTION /at TIME` <br> e.g. `event project meeting /at Aug 6th 2-4pm`, <br> `event project meeting /at 2021-08-06 14:00` |  
| **Delete** | `delete INDEX` <br> e.g. `delete 2` |  
| **List** | `list` |    
| **Find** | `find KEYWORDS` <br> e.g. `find book` |  
| **Done** | `done INDEX` <br> e.g. `done 2` |  
| **Bye** | `bye` |  
  
  
