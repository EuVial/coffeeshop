package temp;

import junit.framework.TestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;

public class SampleTest extends TestCase
{
    private IDatabaseTester databaseTester;

    public SampleTest(String name)
    {
        super(name);
    }

    protected void setUp() throws Exception
    {
        databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
                "jdbc:hsqldb:sample", "sa", "");

        // initialize your dataset here
        IDataSet dataSet = null;
        // ...

        databaseTester.setDataSet( dataSet );
        // will call default setUpOperation
        databaseTester.onSetup();
    }

    protected void tearDown() throws Exception
    {
        // will call default tearDownOperation
        databaseTester.onTearDown();
    }
//    ...
}