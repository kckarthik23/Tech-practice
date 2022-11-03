package com.concurrency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.BestProductHelper;
import com.concurrency.Entity.Catalogs;
import com.concurrency.Entity.Currency;
import com.concurrency.Entity.Laptops;
import com.concurrency.Entity.Products;
import com.concurrency.Entity.Tablets;
import com.concurrency.Services.CatalogService;
import com.concurrency.Services.CurrencyService;
import com.concurrency.Services.ExchangeService;
import com.concurrency.Services.PricingService;
import com.concurrency.Services.ProductService;

/**
 * Hello world!
 *
 */
public class ApplicationLauncher {
    public static void mainThreadProcessor() {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("availble processors is " + numberOfCores);

        Catalogs catalog = CatalogService.getCatalogs("TABLETS");
        Products product = ProductService.getBestProduct(catalog);
        Currency currency = CurrencyService.getCurrency("INR");
        System.out.println(product);
        PricingService.getPrice(product, currency);
        Products prod = ExchangeService.getExchangedProduct(product, currency, catalog);
        System.out.println(" excahnged prod is " + prod);
    }

    public static void main(String[] args) {
        // using main thread
        long startTime = System.currentTimeMillis();
        mainThreadProcessor();
        getExecutionTime(startTime);
        // with parallel processing with threadpools
        startTime = System.currentTimeMillis();
        parallelThreadExecutor();
        getExecutionTime(startTime);
    }

    private static void parallelThreadExecutor() {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("availble processors is " + numberOfCores);
        ExecutorService exec = Executors.newFixedThreadPool(numberOfCores);
        // getting best product go in parallel with pricing and exchange services
        Future res1 = exec.submit(new BestProductHelper());

        Future res2 = exec.submit(() -> {
            double price = PricingService.getPrice(new Laptops(94000, "MACBOOK AIR"), Currency.GBP);
            Products prod = ExchangeService.getExchangedProduct(new Laptops((long) price, "MACBOOK AIR"), Currency.USD,
                    Catalogs.LAPTOPS);
            System.out.println(" excahnged prod is " + prod);
            return prod;
        });
        /*
         * while (!(res1.isDone() && res2.isDone())) {
         * System.out.println(
         * String.format(
         * "future1 is %s and future2 is %s",
         * res1.isDone() ? "done" : "not done",
         * res2.isDone() ? "done" : "not done"
         * )
         * );
         * //Thread.sleep(300);
         * }
         */
        try {
            System.out.println((Products) res1.get(10, TimeUnit.SECONDS));
            System.out.println((Products) res2.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        exec.shutdown();
    }

    private static void getExecutionTime(long startTime) {

        DateFormat simple = new SimpleDateFormat(" ss:SSS Z");
        Date date = new Date(System.currentTimeMillis() - startTime);
        System.out.println("Executor timings :" + (simple.format(date)));
    }
}
