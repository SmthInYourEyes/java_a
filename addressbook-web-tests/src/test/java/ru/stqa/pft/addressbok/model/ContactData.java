package ru.stqa.pft.addressbok.model;


import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String group;

    public ContactData(String id, String firstname, String lastname, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
    }

    public ContactData(int id, String firstname, String lastname, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }

}

