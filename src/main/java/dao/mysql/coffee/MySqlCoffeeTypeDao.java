package dao.mysql.coffee;

import dao.PersistException;
import dao.mysql.AbstractJDBCDao;
import domain.coffee.CoffeeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlCoffeeTypeDao extends AbstractJDBCDao<Integer, CoffeeType> {

    private final static Logger LOGGER = LogManager.getRootLogger();

    private class PersistCoffeeType extends CoffeeType {
        public void setId(final int id) {
            super.setId(id);
        }
    }

    public MySqlCoffeeTypeDao(final Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, type_name, price, disabled\n"
                + "FROM coffeeshop.CoffeeType";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO coffeeshop.CoffeeType (type_name, price, disabled)\n"
                + "VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE coffeeshop.CoffeeType\n"
                + "SET type_name = ?, price = ?, disabled = ?\n"
                + "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM coffeeshop.CoffeeType\n" +
                "WHERE id = ?;";
    }

    @Override
    public String getInitiatesQuery() {
        return "SELECT COUNT(*) AS 'count'\n" +
                "FROM coffeeshop.CoffeeType\n" +
                "WHERE order_id = ? LIMIT 1;";
    }

    @Override
    protected List<CoffeeType> parseResultSet(final ResultSet rs) throws PersistException {
        List<CoffeeType> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistCoffeeType coffeeType = new PersistCoffeeType();
                coffeeType.setId(rs.getInt("id"));
                coffeeType.setTypeName(rs.getString("type_name"));
                coffeeType.setPrice(rs.getDouble("price"));
                coffeeType.setDisabled(rs.getString("disabled").charAt(0));
                result.add(coffeeType);
            }
        } catch (Exception e) {
            LOGGER.warn("Can't parse resultSet");
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(final PreparedStatement statement, final CoffeeType object)
            throws PersistException {
        try {
            statement.setString(1, object.getTypeName());
            statement.setDouble(2, object.getPrice());
            statement.setString(3, String.valueOf(object.getDisabled()));
        } catch (SQLException e) {
            LOGGER.warn("Can't prepare statement for insert");
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(final PreparedStatement statement, final CoffeeType object)
            throws PersistException {
        try {
            statement.setString(1, object.getTypeName());
            statement.setDouble(2, object.getPrice());
            statement.setString(3, String.valueOf(object.getDisabled()));
            statement.setInt(4, object.getId());
        } catch (SQLException e) {
            LOGGER.warn("Can't prepare statement for update");
            throw new PersistException(e);
        }
    }
}
