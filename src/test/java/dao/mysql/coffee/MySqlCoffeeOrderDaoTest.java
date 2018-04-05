package dao.mysql.coffee;

import dao.PersistException;
import dao.datasource.DataSource;
import domain.coffee.CoffeeOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MySqlCoffeeOrderDaoTest{

    @Test
    public void testCRUD(){
        MySqlCoffeeOrderDao mySqlCoffeeOrderDao = new MySqlCoffeeOrderDao(DataSource.getInstance().getConnection());

        CoffeeOrder order = new CoffeeOrder();

        try {
            Assert.assertEquals(order, mySqlCoffeeOrderDao.persist(order));
        } catch (PersistException e) {
            e.printStackTrace();
        }

    }
}