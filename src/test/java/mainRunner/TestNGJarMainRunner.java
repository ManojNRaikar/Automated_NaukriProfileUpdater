package mainRunner;

import org.testng.TestNG;
import java.util.Collections;

public class TestNGJarMainRunner{
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("testng.xml"));
        testng.run();
    }
}
