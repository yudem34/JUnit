package practise.day04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String poom="pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(poom)));
    }
}
