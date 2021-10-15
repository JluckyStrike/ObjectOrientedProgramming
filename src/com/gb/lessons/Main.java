package com.gb.lessons;

import com.gb.lessons.market.Market;
import com.gb.lessons.person.Customer;
import com.gb.lessons.person.Salesman;
import com.gb.lessons.product.Product;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Market market = new Market();

       Salesman salesman1 = new Salesman("Алекс", "Митчелл", new ArrayList<Product>(){
           {
               add( new Product("Яблоки", 3, 30));
               add( new Product("Апельсины", 5, 25));
           }
       });

        Salesman salesman2 = new Salesman("Сэм", "Смит", new ArrayList<Product>(){
            {
                add( new Product("Картофель", 7, 60));
                add( new Product("Помидоры", 5, 80));
            }
        });

        Salesman salesman3 = new Salesman("Клаус", "Смит", new ArrayList<Product>(){
            {
                add( new Product("Картофель", 7, 60));
                add( new Product("Помидоры", 5, 80));
                add( new Product("Бананы", 7, 60));
                add( new Product("Молоко", 5, 80));
                add( new Product("Сгущенка", 5, 80));
            }
        });

        market.addSalesman(salesman1);
        market.addSalesman(salesman2);
        market.addSalesman(salesman3);

        Customer customer1 = new Customer(new ArrayList<Product>(){
            {
                add( new Product("Картофель",  3));
                add( new Product("Помидоры",  10));
                add( new Product("Сгущенка",  2));
            }
        }, 200);

        Customer customer2 = new Customer(new ArrayList<Product>(){
            {
                add( new Product("Яблоки",  3));
                add( new Product("Апельсины",  10));
                add( new Product("Сгущенка",  1));
            }
        }, 90);

        customer1.findProductAndSalesmanOnMarket(market, salesman3);
        // customer1.findProductOnMarket(market);
        customer1.whatsBought();

        System.out.println();

        customer2.findProductAndSalesmanOnMarket(market, salesman1);
        customer2.whatsBought();

        System.out.println("\nОстаток товаров у продавцов: ");
        for (Salesman salesman: market.getSalesmanList()) {
            System.out.println(salesman.toString());
        }
    }
}
