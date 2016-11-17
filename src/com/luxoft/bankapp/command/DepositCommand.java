package com.luxoft.bankapp.command;

import com.luxoft.bankapp.bankcommander.BankCommander;

import java.util.Scanner;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class DepositCommand extends AbstractCommand {
    public DepositCommand() {
        super.commandInfo = "DepositCommand";
    }
    @Override
    public void execute() {
        float amount = UtilComand.getAmount();
        UtilComand.deposit(amount);
    }




}
