package com.luxoft.bankapp.command;

import com.luxoft.bankapp.bankcommander.BankCommander;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class GetAccountsCommand extends AbstractCommand {
    public GetAccountsCommand() {
        super.commandInfo = "GetAccountsCommand";
    }
    @Override
    public void execute() {
        System.out.println(BankCommander.currentClient.getAccounts().toString());
    }


}
