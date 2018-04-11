package dao.mysql.coffee;

import dao.datasource.DataSource;
import domain.coffee.CoffeeType;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;

public class MySqlCoffeeTypeDaoTest {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getRootLogger();

    MySqlCoffeeTypeDao mySqlCoffeeTypeDaoTest =
            new MySqlCoffeeTypeDao(DataSource.getInstance().getConnection());
    CoffeeType coffeeType = new CoffeeType();

    @BeforeEach
    void setup(){
        coffeeType.setTypeName("Arabic");
        coffeeType.setPrice(100.0);
        coffeeType.setDisabled('Y');
    }

//    @Test
//    public void testCreate(){
//        try {
//            Assert.assertNotNull(mySqlCoffeeTypeDaoTest.create());
//            CoffeeType persistedCoffeeType = mySqlCoffeeTypeDaoTest.persist(coffeeType);
//            Assert.assertEquals(coffeeType.getPrice(), persistedCoffeeType.getPrice());
//            Assert.assertEquals(coffeeType.getTypeName(), persistedCoffeeType.getTypeName());
//            Assert.assertEquals(coffeeType.getDisabled(), persistedCoffeeType.getDisabled());
//        } catch (PersistException e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void testRead() {
//
//    }
}
