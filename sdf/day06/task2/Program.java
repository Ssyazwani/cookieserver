package sdf.day06.task2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    private Socket socket;

    public Program(Socket socket) {
        this.socket = socket;

    }

    public static void start(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {

      boolean stop = false;
      Console cons = System.console();
      

        String serverResponse = bufferedReader.readLine();
    while ((serverResponse = bufferedReader.readLine()) != null) {
                System.out.println(serverResponse);
    }



 }

 static void extract(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {
    String serverResponse;
    while ((serverResponse = bufferedReader.readLine()) != null) {
        String[] arrayStrings = serverResponse.split(" ");

        switch (arrayStrings[0]) {
            case "product_id:":
                if (serverResponse.length() > 11) {
                    String productId = serverResponse.substring(11);
                    System.out.println("Product ID: " + productId);
                }
                break;

            case "item-count:":
                if (serverResponse.length() > 11) {
                    String itemCount = serverResponse.substring(11);
                    System.out.println("Item Count: " + itemCount);
                }
                break;

            case "budget:":
                if (serverResponse.length() > 7) {
                    String Budget = serverResponse.substring(7);
                    double budget = Double.parseDouble(Budget);
                    System.out.println("Budget: " + Budget);
                }
                break;

            case "title:":
                if (serverResponse.length() > 6) {
                    String itemTitle = serverResponse.substring(6);
                    System.out.println("Title: " + itemTitle);
                }
                break;

            case "price:":
                if (serverResponse.length() > 6) {
                    String itemPrice = serverResponse.substring(6);
                    System.out.println("Price: " + itemPrice);
                }
                break;

            case "rating:":
                if (serverResponse.length() > 7) {
                    String itemRating = serverResponse.substring(7);
                    System.out.println("Rating: " + itemRating);
                }
                break;

            case "prod_start":
                String startDelimiter = "prod_start";
                String endDelimiter = "prod_end";

                int startIndex = serverResponse.indexOf(startDelimiter);
                int endIndex = serverResponse.indexOf(endDelimiter, startIndex + startDelimiter.length());

                if (startIndex != -1 && endIndex != -1) {
                    String extractedValue = serverResponse.substring(startIndex + startDelimiter.length(), endIndex).trim();
                    System.out.println("Extracted value: " + extractedValue);
                } else {
                    System.out.println("Delimiters not found in the input string.");
                }
                break;

            default:
                // Handle other cases if needed
                break;
        }
    }
}

              
 } 
        //   while (!stop) {
        // String line = cons.readLine("> ");
        // line = line.trim() + "\n";

       //  bufferedWriter.write(line);
        // bufferedWriter.flush();

  //  }
           
            
    

 
