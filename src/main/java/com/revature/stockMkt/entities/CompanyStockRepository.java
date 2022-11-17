package com.revature.stockMkt.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyStockRepository extends JpaRepository<CompanyStock, Integer> {
    Optional<CompanyStock> findByTickerSymbol(String tickerSymbol);
}
