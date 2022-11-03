package com.concurrency.Services;

import com.concurrency.Entity.Currency;

public class CurrencyService {
    public static Currency getCurrency(String currency)
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
switch(currency)
{
    case "INR" :
    return Currency.INR;

    case "USD" :
    return Currency.USD;

    case "YEN" :
    return Currency.YEN;

    case "EURO" :
    return Currency.EURO;

    case "GBP" :
    return Currency.GBP;

    default :return null;
    
}
}
}
