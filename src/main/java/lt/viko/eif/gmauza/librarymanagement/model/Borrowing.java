package lt.viko.eif.gmauza.librarymanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "borrowing")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String borrowDate;
    private String returnDate;
    @OneToOne(targetEntity = Item.class ,cascade = CascadeType.ALL)
    private Item item;

    public Borrowing() {
    }

    public Borrowing(String borrowDate, String returnDate, Item item) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.item = item;
    }

    public Borrowing(int id, String borrowDate, String returnDate, Item item) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return String.format("\n\t\t\t\t\tBorrowed items: " +
                        "\n\t\t\t\t\t\tID = %s" +
                        "\n\t\t\t\t\t\tBorrow Date = %s" +
                        "\n\t\t\t\t\t\tReturn Date = %s" +
                        "\n%s",
                this.id, this.borrowDate, this.returnDate, this.item);
    }


}
