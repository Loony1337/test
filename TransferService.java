
package com.bank.service;

import com.bank.entity.Card;
import com.bank.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final CardRepository repo;

    public TransferService(CardRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Card from = repo.findById(fromId).orElseThrow();
        Card to = repo.findById(toId).orElseThrow();

        if (from.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money");
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        repo.save(from);
        repo.save(to);
    }
}
