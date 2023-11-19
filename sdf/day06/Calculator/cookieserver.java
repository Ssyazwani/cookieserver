package sdf.day06.Calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class cookieserver implements Runnable{ // need to implement run method
    
    public static void Server (int args) throws Exception {
        System.out.println("listening on port");  // int port = DEFAULT_PORT
                                                    // if args.length>0
                                                    //port = Integer.parseInt(args[0])-->switch method
        ServerSocket server = new ServerSocket(3000);

        //create a threadpool
        ExecutorService thrPool = Executors.newFixedThreadPool(2);
        // wait for connection
        // pass the work/program to the thread 
        // create a runnable ___ = new________, create a class to run the class using thrPool.submit(___)

        while(true){
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();

            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            List<String>fortunecookieList = new ArrayList<String>();
           


           if (line.equals("cookie")) {
              try {BufferedReader reader = new BufferedReader(isr);
              FileWriter fileWriter = new FileWriter("fortunecookie.txt"); 
              BufferedWriter writer = new BufferedWriter(fileWriter);
              String fortunecookieString = Arrays.toString(line.split("\n"));
              Stream<String> sentence = reader.lines();


             String fortune = fortunecookieList.get(0);
           //  writer.write(fortunecookieList[0]);

           
           

               bw.write(line);
               bw.flush();
               bw.close();
               is.close();
               os.close();

            }
                
               catch (Exception e) {
                // TODO: handle exception
              } 

              

              

        
        
    }

        }
    }

    @Override
    public void run() { //- entry point of thread is run ==> can Runnable = new
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}

    
// create an object with Cookie
// public class Cookie--> private List<String> cookies, private Random rand = new SecureRandom()

// try catch method

// load file by
// Cookie cookie = new Cookie(cookieFile)

// open serversocket
//while(true)
//socket client = server.accept()

//Use clienthandler

//public void start() throws Exception{ inputstream, outputstream}
//put all the bloody bufferedreader, writer
//while(!stop) String line= br.readLine(), int count = 1, line.trim(), if line.length()<=0 continue;
// string[] tokens = line.split()
//  use switch methods switch (tokens[0]), case (Constants.cookie) case(Constants.End) , stop = true, break;--> extra**redo shoppingcart using switch method
// create a constant file

//cookieCount = cookies.size(); random : int idx=rand.nextInt(cookieCount);
//toReturn.add(cookies.get(idx))
//remember to flush hahahaha

//homework: client can only request for 5 cookies 

// client( +-/x), server calculator (multithreaded)-->(3,4,+) not 3+4