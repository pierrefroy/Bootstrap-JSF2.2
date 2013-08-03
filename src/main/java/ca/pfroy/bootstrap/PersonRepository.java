package ca.pfroy.bootstrap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael Kurz
 */
@ApplicationScoped
public class PersonRepository implements Serializable {

    private Map<Integer, Person> persons = new TreeMap<>();

    @PostConstruct
    protected void init() {
        persons.put(1, new Person(1, "Person 1", "person1@server.com"));
        persons.put(2, new Person(2, "Person 2", "person2@server.com"));
        persons.put(3, new Person(3, "Person 3", "person3@server.com"));
        persons.put(4, new Person(4, "Person 4", "person4@server.com"));
        persons.put(5, new Person(5, "Person 5", "person5@server.com"));
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons.values());
    }

    public Person getPerson(int id) {
        return persons.get(id);
    }
}
