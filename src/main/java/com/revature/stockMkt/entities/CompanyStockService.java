package com.revature.stockMkt.entities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyStockService implements ICompanyStockService{

    private CompanyStockRepository repository;

    @Autowired
    public CompanyStockService(CompanyStockRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompanyStock saveCompanyStock(CompanyStock stock) {
        Optional<CompanyStock> savedStock = repository.findByTickerSymbol(stock.getTickerSymbol());
//        if(savedStock.isPresent()){
//            throw new ResourceNotFoundException("Stock already exist with given ticker symbol: " + stock.getTickerSymbol());
//        }
        return repository.save(stock);
    }

    @Override
    public List<CompanyStock> getAllCompanyStocks() {
        return repository.findAll();
    }

    @Override
    public Optional<CompanyStock> getCompanyStockById(int id) {
        return repository.findById(id);
    }

    public Optional<CompanyStock> getCompanyStockByTickerSymbol(String symbol) {
        return repository.findByTickerSymbol(symbol);
    }

    @Override
    public CompanyStock updateCompanyStock(CompanyStock stock) {
        return repository.save(stock);
    }

    @Override
    public void deleteCompanyStock(int id) {
        repository.deleteById(id);
    }
}
