package com;

import java.util.concurrent.Callable;

import com.concurrency.Entity.Catalogs;
import com.concurrency.Entity.Currency;
import com.concurrency.Entity.Products;
import com.concurrency.Services.ProductService;
import com.concurrency.Services.CatalogService;
import com.concurrency.Services.CurrencyService;

public class BestProductHelper implements Callable<Products> {

    @Override
    public Products call() throws Exception {
        // TODO Auto-generated method stub
        Catalogs catalog= CatalogService.getCatalogs("SMARTPHONES");
        Products product=ProductService.getBestProduct(catalog);
        Currency currency= CurrencyService.getCurrency("USD");
 //System.out.println(product);
        return product;
    }
    
}
