package domain.coffee;

import dao.Identified;
import domain.Entity;

public class CoffeeType extends Entity implements Identified<Integer> {
    private String typeName;
    // TODO: try change to simple type
    private Double price;
    // TODO: try change to simple type
    private Character disabled;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Character getDisabled() {
        return disabled;
    }

    public void setDisabled(Character disabled) {
        this.disabled = disabled;
    }
}
