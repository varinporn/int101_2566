package work02;

import work01.Utilitor;

import java.util.Objects;

public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname){
            this.firstname = Utilitor.testString(firstname);
            this.lastname = Utilitor.testString(lastname);
            this.id = nextId;
            nextId++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Person(");
        sb.append(id).append(",");
        sb.append(firstname).append(",");
        sb.append(lastname).append(")");
        return sb.toString();
    }

    public int getId(){
        return id;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setFirstname(String firstname){
        this.firstname = Utilitor.testString(firstname);
    }

    public void setLastname(String lastname){
        this.lastname = Utilitor.testString(lastname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
    }

}
