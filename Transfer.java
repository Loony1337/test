
package com.bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Card fromCard;

    @ManyToOne
    private Card toCard;

    private BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();
}
