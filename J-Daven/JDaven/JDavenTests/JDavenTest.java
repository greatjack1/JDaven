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
        System.out.println("test started");
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
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);
        } catch (Exception ex) {
            ex.printStackTrace();

            minyanim my = new minyanim();
            Gson gson = new Gson();
            System.out.println(gson.toJson(my));
        }

    }

    @Test
    public void TestLatitudeLongitude() {
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);
        } catch (Exception ex) {
            ex.printStackTrace();

            minyanim my = new minyanim();
            Gson gson = new Gson();
            System.out.println(gson.toJson(my));
        }

    }

    @Test
    public void TestMultipleResults() {
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);
        } catch (Exception ex) {
            ex.printStackTrace();

            minyanim my = new minyanim();
            Gson gson = new Gson();
            System.out.println(gson.toJson(my));
        }

    }

    @Test
    public void TestJDavenFull() {
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);
        } catch (Exception ex) {
            ex.printStackTrace();

            minyanim my = new minyanim();
            Gson gson = new Gson();
            System.out.println(gson.toJson(my));
        }

    }

    @Test
    public void TestJDavenstable() {
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);
        } catch (Exception ex) {
            ex.printStackTrace();

            minyanim my = new minyanim();
            Gson gson = new Gson();
            System.out.println(gson.toJson(my));
        }

    }
}