package lt.viko.eif.gmauza.librarymanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int productionYear;
    private int copiesNumber;
    private boolean status;

    public Item() {
    }

    public Item(String title, String author, String publisher, int productionYear, int copiesNumber, boolean status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.productionYear = productionYear;
        this.copiesNumber = copiesNumber;
        this.status = status;
    }

    public Item(int id, String title, String author, String publisher, int productionYear, int copiesNumber, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.productionYear = productionYear;
        this.copiesNumber = copiesNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("\t\t\t\t\t\tItem: " +
                        "\n\t\t\t\t\t\t\tID = %s" +
                        "\n\t\t\t\t\t\t\tTitle = %s" +
                        "\n\t\t\t\t\t\t\tAuthor = %s" +
                        "\n\t\t\t\t\t\t\tPublisher = %s" +
                        "\n\t\t\t\t\t\t\tProductionYear = %s" +
                        "\n\t\t\t\t\t\t\tCopiesNumber = %s" +
                        "\n\t\t\t\t\t\t\tStatus = %s",
                this.id, this.title, this.author, this.publisher, this.productionYear, this.copiesNumber, this.status);
    }
}
