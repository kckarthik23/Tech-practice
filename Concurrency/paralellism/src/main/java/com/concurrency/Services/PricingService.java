package com.concurrency.Services;

import com.concurrency.Entity.Currency;
import com.concurrency.Entity.Products;

public class PricingService {

    public static  double getPrice(Products product,Currency currency)
    {
float GST=0.18f;
       
switch(currency)
{
    case INR:
    return product.getDefaultPrice()*GST+product.getDefaultPrice();

    case USD:
    return product.getDefaultPrice()*83;

    case EURO:
    return product.getDefaultPrice()*81;

    case YEN:
    return product.getDefaultPrice()*.5;

    default: return product.getDefaultPrice();
}
    }
    
}
