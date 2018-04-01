package dao.mysql.coffee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCoffeeOrderDaoTest {
    @BeforeEach
    void setUp() {
        MySqlCoffeeOrderDao(new Connection())
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void parseResultSet() {
    }

    @Test
    void prepareStatementForInsert() {
    }

    @Test
    void prepareStatementForUpdate() {
    }

}