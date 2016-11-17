package com.luxoft.bankapp.bankcommander;

import com.luxoft.bankapp.command.*;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class BankCommander {
    public  static Bank currentBank = new Bank();
    public  static Client currentClient;
    public static Command[] commands = {
            new FindClientCommand(),
            new AddClientCommand(),
            new DepositCommand(),
            new GetAccountsCommand(),
            new TransferCommand(),
            new WithDrawCommand(),
            new Command() {

                @Override
                public void execute() {
                    System.exit(0);
                }

                @Override
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };
    //public static void main(String args[]) {

    //}
    public static void showMenu() {
        for(int i = 0; i < commands.length; i++) {
            System.out.print(i+1 + ") ");
            commands[i].printCommandInfo();
        }
    }

}
