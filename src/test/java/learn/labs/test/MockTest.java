package learn.labs.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void mockTest(){

        // Membuat object tiruan menggunakan mockit
        List<String> list = Mockito.mock(List.class);

        // Menambahkan behaviour ke dalam mock
        Mockito.when(list.get(0)).thenReturn("Hadi");
        Mockito.when(list.get(100)).thenReturn("Andi");

        System.out.println(list.get(0));
        System.out.println(list.get(100));
        System.out.println(list.get(100));

        // Membuat verifikasi
        // Cek apakah method list.get(0) di panggil hanya satu kali?
        Mockito.verify(list, Mockito.times(1)).get(0);

        // Cek apakah method list.get(100) di panggil hanya satu kali?
        Mockito.verify(list, Mockito.times(1)).get(100); // -> Error karena list.get(100) di panggil 2 kali
    }
}
