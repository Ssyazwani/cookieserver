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
      while (!stop) {
         String line = cons.readLine("> ");
         line = line.trim() + "\n";

         bufferedWriter.write(line);
         bufferedWriter.flush();

        String serverResponse = bufferedReader.readLine();
    while ((serverResponse = bufferedReader.readLine()) != null) {
                System.out.println(serverResponse);

                String[] arrayStrings = serverResponse.split(" ");
                
           switch(arrayStrings[0]){
            case "product_id:":
            if(serverResponse.length()> 11){
                 String productId = serverResponse.substring(11);
                 System.out.println("okay");
            }
            
            case "item-count:":
            if(serverResponse.length()> 11){
            String itemCount = serverResponse.substring(11);
            System.out.println("okay");
            }
            
            case "budget:":
            if(serverResponse.length()> 11){
            String Budget = serverResponse.substring(7);
            System.out.println("okay");
            }
            case "title:":
            if(serverResponse.length()> 11){
            String itemTitle = serverResponse.substring(6);
            System.out.println("okay");
            }
            case "price:":
            if(serverResponse.length()> 11){
            String itemPrice = serverResponse.substring(6);
            System.out.println("okay");
            }
            case "rating:":
            if(serverResponse.length()> 11){
            String itemRating = serverResponse.substring(7);
            System.out.println("okay");
            }
            else{
                continue;
            }
           } 

           Map<String, Integer> ratingItem = new HashMap<>();
           Map<String, Integer> pricingItem = new HashMap<>();
       
      
    }

        // Close the socket and buffered reader if necessary
        socket.close();
        bufferedReader.close();
    }
 }

  }
