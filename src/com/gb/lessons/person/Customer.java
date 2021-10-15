package com.gb.lessons.person;

import com.gb.lessons.market.Market;
import com.gb.lessons.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    List<Product> purchaseList;
    List<Product> expectedPurchaseList;

    public Customer(List<Product> expectedPurchaseList, int cash) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        this.purchaseList.add(product);
    }

    public void findProductOnMarket(Market market) {
        for (Product product : expectedPurchaseList) {
            for (Salesman salesman : market.getSalesmanList()) {
                boolean isBought = salesman.sellProducts(this, product);
                if (isBought) break;
            }
        }
    }

    // Ищем по продавцу и продукту
    public void findProductAndSalesmanOnMarket(Market market, Salesman ourSalesman) {
        boolean isBought = false;
        List<Product> copyExpectedPurchaseList = new ArrayList<>(expectedPurchaseList);

        for (Product product : copyExpectedPurchaseList) {
            for (Salesman salesman : market.getSalesmanList()) {
                // Если продавец совпадает с тем, что мы искали, начинаем искать нужные нам товары
                if (salesman.getName().equals(ourSalesman.getName())) {
                    isBought = salesman.sellProducts(this, product);
                }

                if (isBought) { // Если такой товар имеется, то вычеркиваем его из нашего списка
                    expectedPurchaseList.remove(product);
                    isBought = false;
                }
            }
        }

        // Если у нашего продавца нет всех товаров из нашего списка, то начинаем искать у других продовцов
        if (expectedPurchaseList.size() != 0) {
            System.out.println("У нашего продавца, (" + ourSalesman.getName() + ") нет таких товаров (либо недостаточно денег):");
            for (Product product : expectedPurchaseList) {
                System.out.println("Ищем у других продавцов\n" + "- " + product.getName());
            }
            findProductOnMarket(market);
        } else {
            System.out.println("У нашего продавца, (" + ourSalesman.getName() + ") есть нужные нам товара");
        }

    }

    public void whatsBought() {
        if (purchaseList.size() != 0) {
            for (Product product : purchaseList) {
                System.out.println("Куплено: " + product.getName() + ", в кол-ве " + product.getCount() + " шт.");
            }
        } else {
            System.out.println("Ничего не купил :(");
        }

        System.out.println("Денег осталось: " + this.getCash());
    }

}
