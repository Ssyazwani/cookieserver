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
      
              inputStreamReader = new InputStreamReader(socket.getInputStream());  
              outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());  
              bufferedReader = new BufferedReader(inputStreamReader);  
              bufferedWriter = new BufferedWriter(outputStreamWriter);  

              while (true){  
                  String msgFromClient = bufferedReader.readLine();  
                  System.out.println("Client: " + msgFromClient);   
                  bufferedWriter.write(" MSG Received"); 
                  bufferedWriter.newLine();  
                  bufferedWriter.flush(); 

                  if(msgFromClient.equals("get-cookie")){
                    bufferedWriter.write("Cookie received");
                  }

                  if (msgFromClient.equalsIgnoreCase("BYE"))  
                  break;  
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
      

