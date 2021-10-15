package com.gb.lessons.market;

import com.gb.lessons.person.Salesman;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Salesman> salesmanList;

    public void addSalesman(Salesman salesman){
        if (salesmanList == null){
            salesmanList = new ArrayList<>();
        }

        salesmanList.add(salesman);
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(List<Salesman> salesmanList) {
        this.salesmanList = salesmanList;
    }
}
