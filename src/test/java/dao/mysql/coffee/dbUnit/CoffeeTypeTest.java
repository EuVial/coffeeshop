package dao.mysql.coffee.dbUnit;

import dao.mysql.coffee.MySqlCoffeeTypeDao;
import domain.coffee.CoffeeType;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.logic.CoffeeTypeServiceImpl;

import java.io.File;
import java.util.List;

public class CoffeeTypeTest extends DBUnitConfig {
    private CoffeeTypeServiceImpl service = new CoffeeTypeServiceImpl();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                new File("src/test/resources/dbUnit/coffeeShop/coffeeType.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public CoffeeTypeTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
//        ScriptReader.execute("src/test/h2sql/dump/COFFEE_TYPE.sql", connection);
        MySqlCoffeeTypeDao coffeeTypeDao = new MySqlCoffeeTypeDao(connection);
        service.setCoffeeTypeDao(coffeeTypeDao);
        List<CoffeeType> coffeeTypeList = service.findAll();
        IDataSet expectedData = new FlatXmlDataSetBuilder()
                .build(new File("src/test/resources/dbUnit/coffeeShop/coffeeType.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        System.out.println("expected:");
        System.out.println(expectedData.getTable("coffeeType"));
        System.out.println("actual:");
        System.out.println(actualData.getTable("coffeeType"));
//        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("coffeeType").getRowCount(), coffeeTypeList.size());
    }

//    @Test
//    public void testSave() throws Exception {
//        Person person = new Person();
//        person.setName("Lilia");
//        person.setSurname("Vernugora");
//
//        service.save(person);
//
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("com/devcolibri/entity/person/person-data-save.xml"));
//
//        IDataSet actualData = tester.getConnection().createDataSet();
//
//        String[] ignore = {"id"};
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
//    }

    //others tests

}