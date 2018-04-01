package domain.coffee;

import dao.Identified;
import domain.Entity;

import java.util.Date;

public class CoffeeOrder extends Entity implements Identified<Integer> {
    private Date orderDate;
    private String name;
    private String deliveryAddress;
    // TODO: try change to simple type
    private Double cost;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(final String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(final Double cost) {
        this.cost = cost;
    }
}