package com.luxoft.bankapp.command;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

/**
 * Created by omsk19 on 11/10/2016.
 */
public class TransferCommand extends AbstractCommand {
    public TransferCommand() {
        super.commandInfo = "TransferCommand";
    }

    @Override
    public void execute() {
        int indexClient = UtilComand.findClient(UtilComand.getFromKeyboard());
        if(indexClient!=UtilComand.getNumOfClients()) {
            float amount = UtilComand.getAmount();
            int indexClient1 = UtilComand.findClient(UtilComand.getFromKeyboard());

            try {
                UtilComand.withdrawByIndex(amount, indexClient);
                UtilComand.depositByIndex(amount, indexClient1);
            } catch (NotEnoughFundsException e) {
                System.out.println("Not enough found!!!s");
            }

        }
    }

}
