package learn.labs.test.repository;

import learn.labs.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);
}
