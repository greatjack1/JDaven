package JDavenTests;

import org.junit.Test;

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
    public void TestJDavenFull() {
        System.out.println("test started");
        try {
            JDaven daven = new JDaven("kollel bnei torah", 20);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}