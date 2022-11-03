package com.concurrency;

import com.concurrency.Entity.Catalogs;
import com.concurrency.Entity.Currency;
import com.concurrency.Entity.Products;
import com.concurrency.Services.CatalogService;
import com.concurrency.Services.CurrencyService;
import com.concurrency.Services.ExchangeService;
import com.concurrency.Services.PricingService;
import com.concurrency.Services.ProductService;

/**
 * Hello world!
 *
 */
public class ApplicationLauncher 
{

    public static void main( String[] args )
    {
       long startTime= System.currentTimeMillis();
       Catalogs catalog= CatalogService.getCatalogs("TABLETS");
       Products product=ProductService.getBestProduct(catalog);
       Currency currency= CurrencyService.getCurrency("INR");
System.out.println(product);
       PricingService.getPrice(product, currency);
ExchangeService.getExchangedProduct(product, currency, catalog);
System.out.println(System.currentTimeMillis()-startTime);
    }
}
