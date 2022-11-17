package com.revature.stockMkt.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class CompanyStockController {
    private CompanyStockService service;

    @Autowired
    public CompanyStockController(CompanyStockService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyStock createCompanyStock(@RequestBody CompanyStock stock){
        return service.saveCompanyStock(stock);
    }

    @GetMapping
    public List<CompanyStock> getAllCompanyStocks(){
        return service.getAllCompanyStocks();
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyStock> getCompanyStockById(@PathVariable("id") int stockId){
        return service.getCompanyStockById(stockId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<CompanyStock> updateCompanyStock(@PathVariable ("id") int stockId,
                                                            @RequestBody CompanyStock stock){
        return service.getCompanyStockById(stockId).map(savedStock -> {
            savedStock.setCompanyName(stock.getCompanyName());
            savedStock.setTickerSymbol(stock.getTickerSymbol());
            savedStock.setPrice(stock.getPrice());
            savedStock.setStocks(stock.getStocks());
            savedStock.setMarketCap(stock.getMarketCap());

            CompanyStock updatedCompanyStock = service.updateCompanyStock(savedStock);
            return new ResponseEntity<>(updatedCompanyStock, HttpStatus.OK);
        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> deleteCompanyStock(@PathVariable("id") int stockId){
        service.deleteCompanyStock(stockId);
        return new ResponseEntity<String>("Company Stock deleted Successfully!", HttpStatus.OK);
    }

}
