
package com.bank.controller;

import com.bank.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public void transfer(@RequestParam Long from,
                         @RequestParam Long to,
                         @RequestParam BigDecimal amount) {
        service.transfer(from, to, amount);
    }
}
