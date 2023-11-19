package sdf.day06.task2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void start(Socket socket, BufferedReader bufferedReader,BufferedWriter bufferedWriter) throws IOException {

        Scanner scanner = new Scanner(System.in); 
        while (true) {
            String msgToSend = scanner.nextLine();
            bufferedWriter.write(msgToSend);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            

        String pattern = "id: (\\d+), title: (\\w+), price: (\\d+), rating: (\\d+)";

        String serverResponse = bufferedReader.readLine();

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regex.matcher(serverResponse);

        // Check if the pattern matches the input
        if (matcher.find()) {
            // Extract information using group numbers
            String id = matcher.group(1);
            String title = matcher.group(2);
            String price = matcher.group(3);
            String rating = matcher.group(4);

            // Print the extracted information
            System.out.println("ID: " + id);
            System.out.println("Title: " + title);
            System.out.println("Price: " + price);
            System.out.println("Rating: " + rating);
        } else {
            System.out.println("Pattern not found in the input string.");
        }

        // Close the socket and buffered reader if necessary
        socket.close();
        bufferedReader.close();
    }
 }

}
