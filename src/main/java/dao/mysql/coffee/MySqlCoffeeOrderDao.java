package dao.mysql.coffee;

import dao.PersistException;
import dao.mysql.AbstractJDBCDao;
import domain.coffee.CoffeeOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySqlCoffeeOrderDao extends AbstractJDBCDao<Integer, CoffeeOrder> {

    private final static Logger LOGGER = LogManager.getRootLogger();

    private class PersistCoffeeOrder extends CoffeeOrder {
        public void setId(final int id) {
            super.setId(id);
        }
    }

    public MySqlCoffeeOrderDao(final Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, order_date, name, delivery_address, cost "
                + "FROM coffee.CoffeeOrder";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO coffee.CoffeeOrder (order_date, name, delivery_address, cost "
                + "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE coffee.CoffeeOrder\n"
                + "SET order_date = ?, name = ?, delivery_address = ?, cost = ?, "
                + "WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM coffee.CoffeeOrder WHERE id = ?";
    }

    @Override
    public String getInitiatesQuery() {
        return "SELECT COUNT(*) AS 'count' FROM coffee.CoffeeOrderItem WHERE order_id = ? LIMIT 1;";
    }

    @Override
    protected List<CoffeeOrder> parseResultSet(final ResultSet rs) throws PersistException {
        List<CoffeeOrder> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistCoffeeOrder coffeeOrder = new PersistCoffeeOrder();
                coffeeOrder.setId(rs.getInt("id"));
                coffeeOrder.setOrderDate(new java.util.Date(
                    rs.getTimestamp("order_date").getTime()));
                coffeeOrder.setName(rs.getString("name"));
                coffeeOrder.setDeliveryAddress("delivery_address");
                coffeeOrder.setCost(rs.getDouble("cost"));
                result.add(coffeeOrder);
            }
        } catch (Exception e) {
            LOGGER.warn("Can't parse resultSet");
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(final PreparedStatement statement, final CoffeeOrder object)
            throws PersistException {
        try {
            statement.setTimestamp(1, new Timestamp(object.getOrderDate().getTime()));
            statement.setString(2, object.getName());
            statement.setString(3, object.getDeliveryAddress());
            statement.setDouble(4, object.getCost());
        } catch (SQLException e) {
            LOGGER.warn("Can't prepare statement for insert");
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(final PreparedStatement statement, final CoffeeOrder object)
            throws PersistException {
        try {
            statement.setTimestamp(1, new Timestamp(object.getOrderDate().getTime()));
            statement.setString(2, object.getName());
            statement.setString(3, object.getDeliveryAddress());
            statement.setDouble(4, object.getCost());
            statement.setInt(5, object.getId());
        } catch (SQLException e) {
            LOGGER.warn("Can't prepare statement for update");
            throw new PersistException(e);
        }
    }
}
