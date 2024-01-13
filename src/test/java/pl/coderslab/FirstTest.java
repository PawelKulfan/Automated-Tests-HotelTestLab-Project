package pl.coderslab;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @BeforeClass
    public static void setUpClass(){
        System.out.println("setUpClass");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("tearDownClass");
    }

    @Before
    public void setUp(){
        System.out.println("setUp");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
    }

    @Test
    public void failedTest(){
//        assert 1 == 2;
        System.out.println("failedTest");
        assertEquals("1 ma sie rownac jeden ale: ",1, 2);
    }

    @Test
    public void passTest(){
        System.out.println("passTest");
        assertTrue(true);
    }

    @Test
    public void brokenTest(){
        System.out.println("brokenTest");
        throw new RuntimeException();
    }

}