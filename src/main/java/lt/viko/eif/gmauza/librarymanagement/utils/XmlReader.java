package lt.viko.eif.gmauza.librarymanagement.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlReader {
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
