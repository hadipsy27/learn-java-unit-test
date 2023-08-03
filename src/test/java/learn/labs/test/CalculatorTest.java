package learn.labs.test;

import learn.labs.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk calculator class")
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

    @Test
    //@DisplayName("Test skenario sukses untuk method add(integer, integer) ")
    public void testAddSuccess(){
        var result = calculator.add(10, 10);

        // cara manual
//        if(result != 20){
//            throw  new RuntimeException("Test Gagal!");
//        }

        // Menggunakan Assertion
        assertEquals(20, result);
    }

    @Test
    public void testDevideSuccess(){
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFailed(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(100, 0);
        });

    }

    @Test
    @Disabled
    public void comingsoonTest(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        // How to change Environment
        // 1. goto Run / Debug Configuration
        // 2. chose Edit Configuration
        // 3. In Environment Variables -> Edit Environment Variables (Shift + Enter)
        // 4. Add new
        // 5. Name : PROFILE, Value : DEV
        // 6. Run Test

        if(!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatalkan karena env bukan DEV");
        }

        // Unit test for dev
    }
}
