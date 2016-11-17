package com.luxoft.bankapp.service;

import com.luxoft.bankapp.bankcommander.BankCommander;
import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.model.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by omsk19 on 11/17/2016.
 */
public class LoadBankDataService {



    public static void readFeedData(File file) {
        HashMap<String,String> map = new HashMap<>();
        try {
            Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(file)));
            String line;
            while(scan.hasNext()) {
                line = scan.nextLine();
                String[] newLines = line.split(";");
                for(String str: newLines) {
                    map.put(str.split("=")[0], str.split("=")[1]);
                }
            Client readClient = parseClient(map);
                addClient(BankCommander.currentBank, readClient);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }

    }

    public static Client parseClient(HashMap<String,String> map) {
        Client client;
        if(map.containsKey("overdraft")) {
            client = new Client(map.get("name"), Float.parseFloat(map.get("overdraft")), Client.createGender(map.get("gender")));
        }
        else {
            client = new Client(map.get("name"), Client.createGender(map.get("gender")));
        }
        client.setInitialBalance(Float.parseFloat(map.get("balance")));
        client.addAccount(client.createAccount(map.get("accountType")));
        return client;
    }

    public static void addClient(Bank bank, Client client) {
        try {
            bank.addClient(client);
        } catch (ClientExistsException e) {
            e.printStackTrace();
        }
    }
}
