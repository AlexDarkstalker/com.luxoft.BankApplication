package com.luxoft.bankapp.command;

import com.luxoft.bankapp.bankcommander.BankCommander;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Scanner;

/**
 * Created by omsk19 on 11/14/2016.
 */
public class UtilComand {
    public static String getFromKeyboard() {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        return name;
    }

    public static float getAmount() {
        Scanner scan = new Scanner(System.in);
        return scan.nextFloat();
    }
    public static void withdrawAmount(float amount) {
        return ;
    }

    public static int findClient(String name) {
        int i = -1;
        int numOfClients =  BankCommander.currentBank.getClients().size();
        String nameClient = "";
        while((i < numOfClients)&&(!name.equals(nameClient))) {
            i++;
            nameClient = BankCommander.currentBank.getClients().get(i).getName();
        }
        return i;
    }

    public static void deposit(float amount) {
        BankCommander.currentClient.getActiveAccount().deposit(amount);
    }

    public static void depositByIndex(float amount, int i) {
        BankCommander.currentBank.getClients().get(i).deposit(amount);
    }


    public static void withdraw(float amount) {
        try {
            BankCommander.currentClient.getActiveAccount().withdraw(amount);
        } catch (NotEnoughFundsException e) {
            System.out.println("Not enough founds");
        }
    }

    public static void withdrawByIndex(float amount, int i) throws NotEnoughFundsException {
        try {
            BankCommander.currentBank.getClients().get(i).withdraw(amount);
        } catch (NotEnoughFundsException e) {
            throw new NotEnoughFundsException(0);
//            System.out.println("Not enough founds");
        }
    }

    public static int getNumOfClients() {
        return BankCommander.currentBank.getClients().size();
    }}
