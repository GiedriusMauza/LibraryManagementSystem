package lt.viko.eif.gmauza.librarymanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;
    private String workHours;

    @OneToMany(targetEntity = Subscriber.class ,cascade = CascadeType.ALL)
    private List<Subscriber> subscribers;

    @OneToOne(targetEntity = Librarian.class ,cascade = CascadeType.ALL)
    private Librarian librarian;


    public Library() {
    }

    public Library(String name, String address, String workHours, Librarian librarian, List<Subscriber> subscribers) {
        this.name = name;
        this.address = address;
        this.workHours = workHours;
        this.subscribers = subscribers;
        this.librarian = librarian;
    }

    public Library(int id, String name, String address, String workHours, Librarian librarian, List<Subscriber> subscribers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workHours = workHours;
        this.subscribers = subscribers;
        this.librarian = librarian;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return String.format("Library: " +
                        "\n\tID = %s" +
                        "\n\tName = %s" +
                        "\n\tAddress = %s" +
                        "\n\tWork Hours = %s" +
                        "\n\t%s" +
                        "\n\t\tSubscribers: %s",
                this.id, this.name, this.address, this.workHours, this.librarian, constructSubscriberList());
    }

    private Object constructSubscriberList() {
        String result = "";
        for (Subscriber subject : this.subscribers) {
            result += subject.toString();
        }
        return result;
    }
}
