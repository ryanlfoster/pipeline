package nl.ikoodi.io.cy.cli.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

@Parameters(
        commandNames = {HelpCommand.CMD_NAME}
        , commandDescription = "Show help information about a command"
)
public class HelpCommand {
    public static final String CMD_NAME = "help";

    @Parameter(
            description = "Command"
            , arity = 1
    )
    private List<String> commands = new ArrayList<String>();

    public List<String> getCommands() {
        return commands;
    }
}