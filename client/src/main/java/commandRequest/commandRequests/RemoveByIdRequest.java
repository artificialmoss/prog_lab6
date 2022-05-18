package commandRequest.commandRequests;

import commandRequest.CommandRequest;
import commandRequest.commandRequests.exceptions.WrongAmountOfArgumentsException;
import commandRequest.commandRequests.exceptions.WrongArgumentException;
import dtos.CommandRequestDTO;

/**
 * Remove element by id request
 */
public class RemoveByIdRequest extends CommandRequest {
    private Long id;

    public RemoveByIdRequest(CommandRequestDTO requestDTO) {
        super("remove", requestDTO);
    }

    @Override
    public CommandRequest setArgs(String[] s) throws WrongAmountOfArgumentsException, WrongArgumentException {
        if (s.length != 2) {
            throw new WrongAmountOfArgumentsException();
        }
        try {
            id = Long.parseLong(s[1]);
        } catch (NumberFormatException e) {
            throw new WrongArgumentException();
        }
        return this;
    }

    @Override
    public Long getId() {
        return id;
    }
}
