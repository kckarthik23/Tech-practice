package com.concurrency.Services;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.concurrency.Entity.Brands;
import com.concurrency.Entity.Catalogs;
import com.concurrency.Entity.Laptops;
import com.concurrency.Entity.Products;
import com.concurrency.Entity.SmartPhones;
import com.concurrency.Entity.SmartWatches;
import com.concurrency.Entity.Tablets;

public class ProductService {

    public static  Products getBestProduct(Catalogs catalog) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        switch (catalog) {
            case TABLETS:
                return new Tablets(54000, "Ipad AIR5");

            case SMARTPHONES:
                return new SmartPhones(34000, "Samsung S20 FE");

            case SMARTWATCHES:
                return new SmartWatches(40000, "Apple Watch SE");

            case LAPTOPS:
                return new Laptops(100000, "MacBook AIR M1");

            default:
                return new Tablets(54000, "Ipad AIR 5");

        }
    }

        
        
    }


