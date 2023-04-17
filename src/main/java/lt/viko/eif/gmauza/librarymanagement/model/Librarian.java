package lt.viko.eif.gmauza.librarymanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Librarian() {
    }

    public Librarian(String name, String lastName, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Librarian(int id, String name, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Librarian: " +
                        "\n\t\tID = %s" +
                        "\n\t\tName = %s" +
                        "\n\t\tLast name = %s" +
                        "\n\t\tPhone = %s"+
                        "\n\t\tEmail = %s",
                this.id, this.name, this.lastName, this.phoneNumber, this.email);
    }
}
