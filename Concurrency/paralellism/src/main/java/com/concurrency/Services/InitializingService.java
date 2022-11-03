package com.concurrency.Services;

import java.util.ArrayList;
import java.util.HashMap;

import com.concurrency.Entity.Brands;
import com.concurrency.Entity.Catalogs;

public class InitializingService {
    final ArrayList<Brands> brands;
    final HashMap<Catalogs, ArrayList<Brands>> products;
    final static InitializingService instance=new InitializingService();
    {
        brands = new ArrayList<>();
        for (Brands value : Brands.values())
            brands.add(value);
        products = new HashMap<>();
        for (Catalogs value : Catalogs.values())
            products.put(value, brands);

    }

    static void init() {
        new InitializingService();
    }

  static  InitializingService get()
    {
        return instance;
    }
}
