package sdf.day06.Calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class cookieclient {

    public static void Client(String[] args) throws Exception {
       System.out.println("YO,YO");
       Socket socket = new Socket("localhost", 3000);

       System.out.println("Connect to Server");

       Console cons = System.console();
        String Line = cons.readLine("Please type cookie");

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(Line +"\n");
        bw.flush();


        InputStream is = socket.getInputStream(); 
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();

        System.out.println("Hello");

        bw.write(Line +"\n");
        bw.flush();
        os.close();
        is.close();



        
    }
    
}

// public CilentHandler ( Socket Client, Cookie cookie)
// this.socket = client;
// this.cookie = cookie;
