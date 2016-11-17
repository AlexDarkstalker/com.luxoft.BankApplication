package com.luxoft.bankapp.command;

/**
 * Created by omsk19 on 11/10/2016.
 */
abstract public class AbstractCommand implements  Command {
    protected String commandInfo;
    @Override
    public void printCommandInfo() {
        System.out.println(this.commandInfo);
    }
}
