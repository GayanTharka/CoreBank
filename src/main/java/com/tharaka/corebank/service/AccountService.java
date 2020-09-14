package com.tharaka.corebank.service;

import com.tharaka.corebank.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AccountService {
    private static final Map<Integer, Account> accounts = new HashMap<>();

    @PostConstruct
    public void initialize() {
        Account account1 = new Account();
        account1.setUserId(1111);
        account1.setAccountNo(123123123);
        account1.setBalance(1000);

        Account account2 = new Account();
        account2.setUserId(2222);
        account2.setAccountNo(789789789);
        account2.setBalance(2320);

        Account account3 = new Account();
        account3.setUserId(3333);
        account3.setAccountNo(567567567);
        account3.setBalance(1230);

        Account account4 = new Account();
        account4.setUserId(1111);
        account4.setAccountNo(456456456);
        account4.setBalance(2000);

        accounts.put(account1.getAccountNo(), account1);
        accounts.put(account2.getAccountNo(), account2);
        accounts.put(account3.getAccountNo(), account3);
        accounts.put(account4.getAccountNo(), account4);
    }

    public Map<Integer, Account> getAccountDetails() {
        return accounts;
    }

    public Double getAccountBalance(int accountNo) {
        return accounts.get(accountNo).getBalance();
    }

    public Double getTotalAccountBalance(int userId) {
        Iterator<Map.Entry<Integer, Account>> it = accounts.entrySet().iterator();
        double totalBalance = 0;
        while (it.hasNext()) {
            Account account = it.next().getValue();
            totalBalance += (userId == -1 || account.getUserId() == userId) ? account.getBalance() : 0;
        }
        return totalBalance;
    }

    public Account fundTransferToOwnAccount(int fromAccountNo, int toAccountNo, double amount) {
        Account fromAccount = null;
        Account toAccount = null;
        if (checkAccountAvailablity(fromAccountNo) && checkAccountAvailablity(toAccountNo)) {
            fromAccount = accounts.get(fromAccountNo);
            toAccount = accounts.get(toAccountNo);
            if (fromAccount.getBalance() > amount) {
                toAccount.setBalance(toAccount.getBalance() + amount);
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                accounts.put(fromAccountNo, fromAccount);
//                accounts.put(toAccountNo, toAccount);
                System.out.println("SUCCESS");
            } else {
                System.out.println("No sufficient credit");
            }
        } else {
            System.out.println("Please check correct account details");
        }
        return fromAccount;
    }

    public Account fundTransferToOtherAccount(int fromAccountNo, int toAccountNo, int bankCode, double amount) {
        Account fromAccount = null;
        if (checkAccountAvailablity(fromAccountNo)) {
            fromAccount = accounts.get(fromAccountNo);
            if (fromAccount.getBalance() > amount) {
                // Assumption - Other bank is out of our system.
                // Send the transferred amount to the other bank account using relevant APIs according to the bank.
                // if the transaction success procceeding
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                accounts.put(fromAccountNo, fromAccount);
                System.out.println("SUCCESS");
            } else {
                System.out.println("No sufficient credit");
            }
        } else {
            System.out.println("Please check correct account details");
        }
        return fromAccount;
    }

    private boolean checkAccountAvailablity(int accountNo) {
        System.out.println("Account : " + accountNo + "availability " + accounts.keySet().contains(accountNo));
        return accounts.keySet().contains(accountNo);
    }
}
