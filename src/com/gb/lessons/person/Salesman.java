package com.gb.lessons.person;

import com.gb.lessons.product.Product;

import java.util.List;

public class Salesman extends Person {
    private String name;
    private String secondName;
    private List<Product> products;

    public Salesman(String name, String secondName, List<Product> products) {
        this.name = name;
        this.secondName = secondName;
        this.products = products;
    }

    public boolean sellProducts(Customer customer, Product wannaBuy) {
        for (Product product : products) {
            if (product.getName().equals(wannaBuy.getName())) {
                if (product.getCount() >= wannaBuy.getCount()) {
                    int requiredCash = wannaBuy.getCount() * product.getPrice();
                    if (customer.getCash() >= requiredCash) {
                        product.setCount(product.getCount() - wannaBuy.getCount());
                        customer.setCash(customer.getCash() - requiredCash);

                        Product customerProduct = new Product();
                        customerProduct.setCount(wannaBuy.getCount());
                        customerProduct.setName(wannaBuy.getName());
                        customer.addPurchase(customerProduct);

                        this.setCash(this.getCash() + requiredCash);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String productsSalesman = "";

        for (Product product : products) {
            productsSalesman += product.getName() + ", " + product.getCount() + " шт.\n";
        }

        return "Имя: " + name  +
                "\nПрдукты: \n" + productsSalesman;
    }
}
