package learn.labs.test;

import learn.labs.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk calculator class")
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
}
