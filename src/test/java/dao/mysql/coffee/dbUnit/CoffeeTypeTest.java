package dao.mysql.coffee.dbUnit;

import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CoffeeTypeTest extends DBUnitConfig{

//    private PersonService service = new PersonService();
//    private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("src/test/resources/dbUnit/coffeeShop/coffeeShop.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public CoffeeTypeTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Person> persons = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("src/test/resources/dbUnit/coffeeShop/coffeeShop.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("person").getRowCount(),persons.size());
    }

    @Test
    public void testSave() throws Exception {
        Person person = new Person();
        person.setName("Lilia");
        person.setSurname("Vernugora");

        service.save(person);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/devcolibri/entity/person/person-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
    }

    //others tests

}