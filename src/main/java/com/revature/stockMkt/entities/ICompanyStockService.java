package com.revature.stockMkt.entities;

import java.util.List;
import java.util.Optional;

public interface ICompanyStockService {
    CompanyStock saveCompanyStock(CompanyStock stock) throws ResourceNotFoundException;
    List<CompanyStock> getAllCompanyStocks();
    Optional<CompanyStock> getCompanyStockById(int id);
    CompanyStock updateCompanyStock(CompanyStock stock);
    void deleteCompanyStock(int id);
}
