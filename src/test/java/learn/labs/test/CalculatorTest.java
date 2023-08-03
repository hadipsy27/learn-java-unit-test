package learn.labs.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
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
}
