package duke.parser;

import duke.DukeException;
import duke.commands.ByeCommand;
import duke.commands.Command;
import duke.commands.DeadlineCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.EventCommand;
import duke.commands.ListCommand;
import duke.commands.TodoCommand;
import duke.common.Messages;

public class Parser {

    public static Command parse(String fullCommand) throws DukeException {
        String[] words = fullCommand.split(" ", 2);
        String wordparts[];
        switch (words[0].toLowerCase()) {
        case "todo":
            try {
                return new TodoCommand(words[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
        case "deadline":
            try {
                wordparts = words[1].split(" /by ");
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            try {
                return new DeadlineCommand(wordparts[0], wordparts[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_DEADLINE);
            }
        case "event":
            try {
                wordparts = words[1].split(" /at ");
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            try {
                return new EventCommand(wordparts[0], wordparts[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_EVENT);
            }
        case "delete":
            try {
                return new DeleteCommand(Integer.parseInt(words[1]));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }
        case "list":
            return new ListCommand();
        case "done":
            try {
                return new DoneCommand(Integer.parseInt(words[1]));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }
        case "bye":
            return new ByeCommand();
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }
}