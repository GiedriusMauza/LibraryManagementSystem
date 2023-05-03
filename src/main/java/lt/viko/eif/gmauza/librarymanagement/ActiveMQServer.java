package lt.viko.eif.gmauza.librarymanagement;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActiveMQServer {

    public static void main(String[] args) {
        thread(new Producer(), false);

    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

    public static class Producer implements Runnable {
        public void run() {
            try {
                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

                // Create a Connection
                Connection connection = connectionFactory.createConnection("admin", "admin");
                connection.start();

                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue("LibraryQueue");

                // Create a MessageProducer from the Session to the Topic or Queue
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                // Create a messages


                String text = ReadFileToString("library.xml");
                System.out.println(text);
                TextMessage message = session.createTextMessage(text);

                // Tell the producer to send the message
                producer.send(message);

                // Clean up
                session.close();
                connection.close();
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }
    }

        public static String ReadFileToString(String filePath) {
            try {
                // create a BufferedReader to read the file
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;
                StringBuilder sb = new StringBuilder();

                // read each line of the file and append it to the StringBuilder
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                // close the BufferedReader
                br.close();

                // print the contents of the file as a string
                return sb.toString();
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            return "";
        }

}