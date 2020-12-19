package com.epam.web.controller.command;

public class CommandResult {
    private final String command;
    private final boolean isRedirect;

    public CommandResult(String command, boolean isRedirect) {
        this.command = command;
        this.isRedirect = isRedirect;
    }

    public static CommandResult forward(String page) {
        return new CommandResult(page, false);
    }

    public static CommandResult redirect(String page) {
        return new CommandResult(page, true);
    }

    public String getCommand() {
        return command;
    }

    public boolean isRedirect() {
        return isRedirect;
    }
}