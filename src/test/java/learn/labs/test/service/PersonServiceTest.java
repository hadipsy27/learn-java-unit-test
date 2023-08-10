package learn.labs.test.service;

import learn.labs.test.data.Person;
import learn.labs.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions(
        @ExtendWith(MockitoExtension.class)
)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        // Mocking object -> dan bisa menambahkan behaviour ke object tersebut
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // Menambah behaviour ke mock object
        Mockito.when(personRepository.selectById("hadi"))
                .thenReturn(new Person("hadi","Hadi"));

        var person = personService.get("hadi");

        Assertions.assertNotNull(person);

        Assertions.assertEquals("hadi", person.getId());
        Assertions.assertEquals("Hadi", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Hadi");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Hadi", person.getName());
        Assertions.assertNotNull(person.getId());

        // Wajib!! membuat verifikasi apakah method yg bersangkutan ke db benar-benar di panggil
        // dengan adanya verifikasi supaya meyakinkan bawah code yg dibuat benar sesuai dengan yg di harapkan
        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(person.getId(), "Hadi"));
    }
}
