package lt.viko.eif.gmauza.librarymanagement;

import lt.viko.eif.gmauza.librarymanagement.utils.JaxbUtil;
import lt.viko.eif.gmauza.librarymanagement.utils.ValidateXmlXsd;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQClient {

    public static void main(String[] args) {
        thread(new Consumer(), false);

    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

    public static class Consumer implements Runnable, ExceptionListener {
        public void run() {
            try {

                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                connection.setExceptionListener(this);

                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue("library.queue");

                // Create a MessageConsumer from the Session to the Topic or Queue
                MessageConsumer consumer = session.createConsumer(destination);

                // Wait for a message
                Message message = consumer.receive(1000);

                if (message instanceof TextMessage textMessage) {
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
                    ValidateXmlXsd.validate(text);
                    System.out.println("Printing object");
                    JaxbUtil.transformToPOJOFromString(text);
                } else {
                    System.out.println("Received: " + message);
                }

                consumer.close();
                session.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }

        public synchronized void onException(JMSException ex) {
            System.out.println("JMS Exception occured.  Shutting down client.");
        }
    }
}