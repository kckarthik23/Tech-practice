package com.concurrency.Services;

import com.concurrency.Entity.Catalogs;

public class CatalogService {
    
    public static Catalogs getCatalogs(String catalog)
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
switch(catalog)
{
    case "TABLETS" :
    return Catalogs.TABLETS;

    case "SMARTPHONES" :
    return Catalogs.SMARTPHONES;

    case "SMARTWATCHES" :
    return Catalogs.SMARTWATCHES;

    case "LAPTOPS" :
    return Catalogs.LAPTOPS;

    default :return null;
    
}

    }
}
