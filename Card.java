
package com.bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String status;
    private BigDecimal balance;

    @ManyToOne
    private User owner;

    public String getMaskedNumber() {
        return "**** **** **** " + cardNumber.substring(cardNumber.length()-4);
    }
}
