package com.concurrency.Services;

import com.concurrency.Entity.Catalogs;
import com.concurrency.Entity.Currency;
import com.concurrency.Entity.Products;

public class ExchangeService {

   public static Products getExchangedProduct(Products product,Currency currency,Catalogs catalog)
   {
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   double exchangedprice= PricingService.getPrice(product, currency)-product.getDefaultPrice()/2;
return ProductService.getBestProduct(catalog);

   } 
    
}
