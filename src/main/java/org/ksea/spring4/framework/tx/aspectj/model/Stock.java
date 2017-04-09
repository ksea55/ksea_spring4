package org.ksea.spring4.framework.tx.aspectj.model;

/**
 * Created by mexican on 2017/4/8.
 * 股票
 */
public class Stock {
    private Integer id;
    private String name; //股票名称
    private int amount;//股票数量

    public Stock() {

    }

    public Stock(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
