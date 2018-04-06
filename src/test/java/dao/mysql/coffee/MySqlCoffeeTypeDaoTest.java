package dao.mysql.coffee;

import dao.PersistException;
import dao.datasource.DataSource;
import domain.coffee.CoffeeType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MySqlCoffeeTypeDaoTest {
    @Test
    public void testCreate(){
        MySqlCoffeeTypeDao mySqlCoffeeTypeDaoTest =
                new MySqlCoffeeTypeDao(DataSource.getInstance().getConnection());

        CoffeeType coffeeType = new CoffeeType();
        coffeeType.setTypeName("Arabic");
        coffeeType.setPrice(100.0);
        coffeeType.setDisabled('Y');

        try {
            CoffeeType persistedCoffeeType = mySqlCoffeeTypeDaoTest.persist(coffeeType);
            Assert.assertEquals(coffeeType.getPrice(), persistedCoffeeType.getPrice());
            Assert.assertEquals(coffeeType.getTypeName(), persistedCoffeeType.getTypeName());
            Assert.assertEquals(coffeeType.getDisabled(), persistedCoffeeType.getDisabled());
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
