package dao.mysql.coffee;

import dao.PersistException;
import dao.datasource.DataSource;
import domain.coffee.CoffeeOrder;
import org.junit.jupiter.api.Test;

import java.util.Date;

class MySqlCoffeeOrderDaoTest{

    @Test
    public void testCRUD(){
        MySqlCoffeeOrderDao mySqlCoffeeOrderDao =
                new MySqlCoffeeOrderDao(DataSource.getInstance().getConnection());

        CoffeeOrder order = new CoffeeOrder();
        order.setCost(10.0);
        order.setDeliveryAddress("Vitebsk, Chkalovo Str.");
        order.setName("Simple order");
        order.setOrderDate(new Date());

        try {
            CoffeeOrder persistedOrder = mySqlCoffeeOrderDao.persist(order);
            System.out.println(persistedOrder.getName());
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}