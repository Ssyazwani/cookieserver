package sdf.day06.Calculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class revcalculator{
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(3000);
        


        while(true){
            System.out.println("Waitin for connection");
            Socket client = socket.accept();// client accepting the socket you created

            InputStream is = client.getInputStream();
            InputStreamReader sr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(sr);
            String input = br.readLine();

        
            String[] inputnumbers = input.split(" ");

            // need to put another loop so the calcu would keep running (like the shopping cart)

            // make array into arraylist, tbh idk what i am doing
            ArrayList<String>listofnumbers = new ArrayList<>();

             
             // how to split numbers and characters????? maybe u dont

            int Num1 = (int) parseInt(listofnumbers.removeLast()); // converting string into integer ( use calculator.last)
            int Num2 = (int) parseInt(listofnumbers.removeLast());
            int Num =0;

            switch(""){
                case"+": Num = Num1 + Num2;  // making them from being strings to being "operators"
                case"-": Num = Num1 - Num2;
                case"/": Num = Num1 / Num2;
                case"*": Num = Num1 * Num2;

                //string terms= line.trim().split(" ")
                //for String t:terms{
                    //switch
                    //float lhs = stack.pop()
                    //float rhs = stack.pop()
                    //if statements abut add: num = num1 + num2
                    //break;

                      //  Stack<float> stack = new Stack<>();
                   //  stack.push();              // supposedly to add the numbers inputted in by the client, on top
                                         // just my guess that the lecturer would use this method 
                                         // pop and push -->results always go back to the stack

                                         //stack - can be use for a maze ( like next word())

                                         //cannot read the second time --> it will be blocked
                                         //one send one read

              //  }


            }
           System.out.println(Num);
           System.out.println("Print print, bye bye"); //print out result aftewards





        
        

        


            

        
            
        }
}

 

    private static Object parseInt(String string) {
        return null;
    }
}


// create a client session file and threeadedserver file and clientcalcu file
// using private rev calculator 
// create public with inputstreamreader, outputstreamreader, bufferedreader and bufferedwriter
// can put top function ( to see what is at the top of the stack)

// apparently he said while(true) loop is dangerous???? idk what is so dangerous
// boolean stop = false
//while(!stop){
// String Line = cons.readline();
// line = line.trim();
  //  stop="exit".equals(line)
  //  if (stop)
  //  continue;  do not read anymore
//}
// evaluate.line()
    
// implement Runnable to CalcuSession
// exceutorService; thrpool.submit() --> threadedserver (entry point so means when you put it in, you would use the thread)
//create instance and then use submit ( anything that implements a runnable is a thread)

// to represent a lambda => thrpool.submit(()) 