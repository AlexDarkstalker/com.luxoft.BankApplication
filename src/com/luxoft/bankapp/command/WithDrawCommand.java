package com.luxoft.bankapp.command;

import com.luxoft.bankapp.bankcommander.BankCommander;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class WithDrawCommand extends AbstractCommand {
    public WithDrawCommand() {
        super.commandInfo = "WithdrawCommand";
    }
    @Override
    public void execute() {
        float amount = UtilComand.getAmount();
        UtilComand.withdraw(amount);
    }




}
