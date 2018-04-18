package dao.mysql.coffee;

import dao.PersistException;
import dao.datasource.DataSource;
import domain.coffee.CoffeeOrder;
import org.junit.jupiter.api.Test;

import java.util.Date;

class MySqlCoffeeOrderDaoTest{

    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    @Test
    public void testCreate(){
        MySqlCoffeeOrderDao mySqlCoffeeOrderDao =
                new MySqlCoffeeOrderDao(DataSource.getInstance().getConnection());
        CoffeeOrder order = new CoffeeOrder();
        order.setCost(10.0);
        order.setDeliveryAddress("Vitebsk, Chkalovo Str.");
        order.setName("Simple order");
        order.setOrderDate(new Date());
        CoffeeOrder persistedOrder = null;
        try {
//            persistedOrder = mySqlCoffeeOrderDao.persist(order);
            System.out.println(mySqlCoffeeOrderDao.create(order));
        } catch (PersistException e) {
            e.printStackTrace();
        }
//        Assert.assertNotNull(persistedOrder);
//        Assert.assertEquals(order.getName(), persistedOrder.getName());
//        Assert.assertEquals(order.getDeliveryAddress(), persistedOrder.getDeliveryAddress());
//        Assert.assertEquals(order.getCost(), persistedOrder.getCost());
//        Assert.assertNotNull(persistedOrder.getOrderDate());
    }
}