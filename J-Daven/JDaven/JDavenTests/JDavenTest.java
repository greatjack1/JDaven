package JDavenTests;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.*;
import static org.junit.Assert.*;

import com.wyre.JDaven.*;

/**
 * Created by yaakov on 3/13/17.
 */
public class JDavenTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void TestShulName() {
        System.out.println("Testing Shul Name");
        try {
            JDaven daven = new JDaven("chabad jewish center", 20);
            //check that it got the proper name
            Assert.assertEquals("Chabad Jewish Center", daven.getMinyanim()[0].getName());

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @Test
    public void TestZipCode() {
        System.out.println("Testing Shul Zipcode");
        try {
            JDaven daven = new JDaven(90001, 20);
            Assert.assertEquals(daven.getMinyanim()[0].getName(), "Chabad Downtown Los Angeles East");
        } catch (Exception ex) {
            ex.printStackTrace();


        }

    }

    @Test
    public void TestLatitudeLongitude() {
        System.out.println("Testing Latitude and Longitude");
        try {
            JDaven daven = new JDaven(42.9876, -72.345, 20);
            Assert.assertEquals(daven.getMinyanim()[0].getName(), "Chabad of Manchester Vermont");
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

  
}