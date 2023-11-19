package sdf.day06.Calculator;

import java.io.*;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class cookieserver{  
  
  public static void main(String[] args) throws IOException {   
      Socket socket ;  
      InputStreamReader inputStreamReader ;  
      OutputStreamWriter outputStreamWriter ;  
      BufferedReader bufferedReader ;  
      BufferedWriter bufferedWriter ;  
      ServerSocket serversocket ;  

     serversocket = new ServerSocket(3000);  
  
      while (true) {  
          try {  
         
              socket = serversocket.accept();  

              InputStream is = socket.getInputStream();
              inputStreamReader = new InputStreamReader(is);  
              OutputStream os = socket.getOutputStream();
              outputStreamWriter = new OutputStreamWriter(os);  
              bufferedReader = new BufferedReader(inputStreamReader);  
              bufferedWriter = new BufferedWriter(outputStreamWriter);  

              while (true) {
                String msgFromClient = bufferedReader.readLine();
                System.out.println("Client: " + msgFromClient);
            
                // Send acknowledgment
                bufferedWriter.write("MSG Received");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            
                // Check for specific message
                if (msgFromClient.equals("Cookie")) {
                    // Send response
                    bufferedWriter.write("Cookie");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            
                if (msgFromClient.equalsIgnoreCase("BYE")) {
                    // Send response
                    bufferedWriter.write("BYE");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }
            }
              socket.close();  
              inputStreamReader.close();  
              outputStreamWriter.close();  
              bufferedReader.close();  
              bufferedWriter.close();  

          } catch (IOException e) {  
              e.printStackTrace();  
          }  
        }  
    }  

      
        }  
      

