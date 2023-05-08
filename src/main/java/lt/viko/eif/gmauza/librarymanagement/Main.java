package lt.viko.eif.gmauza.librarymanagement;

import lt.viko.eif.gmauza.librarymanagement.model.*;
import lt.viko.eif.gmauza.librarymanagement.utils.JaxbUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item(
                1,
                "Knyga1",
                "Jablonskis",
                "Alma Littera",
                1993,
                3,
                true);
        Item item2 = new Item(
                2,
                "Knyga2",
                "Violeta",
                "Alma Littera",
                1998,
                1,
                true);

        Borrowing borrowing1 = new Borrowing(
                1,
                "2021-10-14",
                "2022-12-16",
                item1);

        Borrowing borrowing2 = new Borrowing(
                2,
                "2021-11-14",
                "2023-01-16",
                item2);


        Subscriber subscriber1 = new Subscriber(
                1,
                "Jonas",
                "Jonaitis",
                "Kalno g. 18",
                "+3706712333",
                "jonas@email.ff",
                List.of(borrowing1, borrowing2));

        Librarian librarian1 = new Librarian(
                1,
                "Petras",
                "Petraitis",
                "+370671124124",
                "petras@email.ff");

        Library library = new Library(
                1,
                "Mazvydo",
                "Gedimino pr. 20",
                "14-16",
                librarian1,
                List.of(subscriber1));

        /*System.out.println(library);*/
        String xml = JaxbUtil.transformToXML(library);
        System.out.println(xml);
    }
}