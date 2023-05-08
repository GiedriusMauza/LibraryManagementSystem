package lt.viko.eif.gmauza.librarymanagement;

import lt.viko.eif.gmauza.librarymanagement.model.*;
import lt.viko.eif.gmauza.librarymanagement.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {

    public static void main(String[] args) {

        Item item1 = new Item(
                "Knyga1",
                "Jablonskis",
                "Alma Littera",
                1993,
                3,
                true);
        Item item2 = new Item(
                "Knyga2",
                "Violeta",
                "Alma Littera",
                1998,
                1,
                true);
        Item item3 = new Item(
                "Knyga3",
                "Jonas",
                "Eridanas",
                1990,
                5,
                true);

        Borrowing borrowing1 = new Borrowing(
                "2021-10-14",
                "2022-12-16",
                item1);

        Borrowing borrowing2 = new Borrowing(
                "2021-11-14",
                "2023-01-16",
                item2);

        Borrowing borrowing3 = new Borrowing(
                "2015-05-04",
                "2024-11-06",
                item3);


        Subscriber subscriber1 = new Subscriber(
                "Jonas",
                "Jonaitis",
                "Kalno g. 18",
                "+3706712333",
                "jonas@email.ff",
                List.of(borrowing1, borrowing2, borrowing3));

        Librarian librarian1 = new Librarian(
                "Petras",
                "Petraitis",
                "+370671124124",
                "petras@email.ff");

        Library library = new Library(
                "Mazvydo",
                "Gedimino pr. 20",
                "14-16",
                librarian1,
                List.of(subscriber1));

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(library);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Library> libraries = session.createQuery("from Library", Library.class).list();
            libraries.forEach(lib -> System.out.println(library));

            System.out.println("--------------------------------------------");
            System.in.read();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // server.shutdown()
        }

    }
}
