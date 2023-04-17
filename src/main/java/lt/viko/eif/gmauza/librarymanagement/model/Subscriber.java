package lt.viko.eif.gmauza.librarymanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    @OneToMany(targetEntity = Borrowing.class ,cascade = CascadeType.ALL)
    private List<Borrowing> borrowing;

    public Subscriber() {
    }

    public Subscriber(String name, String lastName, String address, String phone, String email, List<Borrowing> borrowing) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.borrowing = borrowing;
    }

    public Subscriber(int id, String name, String lastName, String address, String phone, String email, List<Borrowing> borrowing) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.borrowing = borrowing;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Borrowing> getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(List<Borrowing> borrowing) {
        this.borrowing = borrowing;
    }

    @Override
    public String toString() {
        return String.format("\n\t\t\tSubscriber: " +
                        "\n\t\t\t\tID = %s" +
                        "\n\t\t\t\tName = %s" +
                        "\n\t\t\t\tLast name = %s" +
                        "\n\t\t\t\tAddress = %s" +
                        "\n\t\t\t\tPhone = %s"+
                        "\n\t\t\t\tEmail = %s" +
                        "\n\t\t\t\tBorrowings: %s",
                this.id, this.name, this.lastName, this.address, this.phone, this.email, constructBorrowingList());
    }

    private Object constructBorrowingList() {
        String result = "";
        for (Borrowing borrowing : this.borrowing) {
            result += borrowing.toString();
        }
        return result;
    }
}
