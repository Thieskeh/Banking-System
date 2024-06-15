package com.bankingsystem.transactionservice.service;

import com.bankingsystem.transactionservice.model.Account;
import com.bankingsystem.transactionservice.model.Transaction;
import com.bankingsystem.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${account.service.url}")
    private String accountServiceUrl;

    public Transaction createTransaction(Transaction transaction) {
        Account fromAccount = getAccount(transaction.getFromAccountId());
        Account toAccount = getAccount(transaction.getToAccountId());

        if (fromAccount.getOpeningAmount().compareTo(transaction.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        fromAccount.setOpeningAmount(fromAccount.getOpeningAmount().subtract(transaction.getAmount()));
        toAccount.setOpeningAmount(toAccount.getOpeningAmount().add(transaction.getAmount()));

        updateAccount(fromAccount);
        updateAccount(toAccount);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    private Account getAccount(Long accountId) {
        return restTemplate.getForObject(accountServiceUrl + "/accounts/" + accountId, Account.class);
    }

    private void updateAccount(Account account) {
        restTemplate.put(accountServiceUrl + "/accounts/" + account.getId(), account);
    }
}
