package com.luxoft.bankapp.command;

import com.luxoft.bankapp.bankcommander.BankCommander;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class FindClientCommand extends AbstractCommand {
    public FindClientCommand() {
        super.commandInfo = "FindClientCommand";
    }
    @Override
    public void execute() {
        String name = UtilComand.getFromKeyboard();
        int numOfClients = UtilComand.getNumOfClients();
        int i = UtilComand.findClient(name);
        if(i!=numOfClients) {
            BankCommander.currentClient = BankCommander.currentBank.getClients().get(i);
            System.out.println(BankCommander.currentClient.toString());
        }
        else
            System.out.println("No client with such name found!!!!");
    }




}
