package com.revature.stockMkt.entities;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "company_stock")
public class CompanyStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "ticker_symbol", unique = true)
    private String tickerSymbol;

    @Column(name = "quantity_of_stock")
    private int stocks;

    @Column(name = "price_per_stock")
    private double price;

    @Column(name = "market_capitalization")
    private int marketCap;

}
