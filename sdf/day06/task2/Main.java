package sdf.day06.task2;


import java.io.*;  
import java.net.Socket;  
import java.util.Scanner;
  
  
public class Main {  

    public static void main(String[] args) {  
        Socket socket = null;  
        InputStreamReader inputStreamReader = null;  
        OutputStreamWriter outputStreamWriter = null;  
        BufferedReader bufferedReader = null;  
        BufferedWriter bufferedWriter = null;  
        
        try {  
            socket = new Socket("localhost", 3000);  
            inputStreamReader = new InputStreamReader(socket.getInputStream());  
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());  
            bufferedReader = new BufferedReader(inputStreamReader);  
            bufferedWriter = new BufferedWriter(outputStreamWriter);  

          //  String serverResponse;
          //  while ((serverResponse = bufferedReader.readLine()) != null) {
          //      System.out.println(serverResponse);
          //  }

            Program sess = new Program(socket);
            Program.start(socket, bufferedWriter, bufferedReader);
            Program.extract(socket, bufferedWriter, bufferedReader);

            System.out.println("Continue");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
           
    

