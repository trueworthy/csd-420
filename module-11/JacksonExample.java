// Lea Trueworthy
// May 17, 2025
// M11 Programming assignment
// Description: Example code using Jackson, user name Galaxy [wink wink]

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        try {
            // Create an object
            Person person = new Person("Galaxy", 50);

            // Create OObjectMapper objectMapper = new ObjectMapper();

            // Convert Java object to JSON string
            String jsonString = objectMapper.writeValueAsString(person);
            System.out.println("Serialized JSON: " + jsonString);

            // Convert JSON string back to Java object
            Person deserializedPerson = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Deserialized Object: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    // Default constructor is needed for Jackson
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

