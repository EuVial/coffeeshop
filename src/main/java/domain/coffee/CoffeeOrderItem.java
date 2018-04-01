package domain.coffee;

import dao.Identified;
import domain.Entity;

public class CoffeeOrderItem extends Entity implements Identified<Integer> {
    private CoffeeType coffeeType;
    private CoffeeOrder coffeeOrder;
    // TODO: try change to simple type
    private Integer quantity;

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(final CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(final CoffeeOrder coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
