package sdf.day06.task2;


import java.io.*;  
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
  


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

            boolean stop = false;
            Console cons = System.console();
            List<Product> productList = new ArrayList<>();
            double budget = 0;  // Initialize the budget
            Product product = null; 
            Request request = null;

            String serverResponse;
            while ((serverResponse = bufferedReader.readLine()) != null) {
                System.out.println(serverResponse);

                String[] arrayStrings = serverResponse.split(":");

                
                switch (arrayStrings[0]) {
                    case "request_id:":
                    if (serverResponse.length() > 14) {
                            String requestId = serverResponse.substring(14).trim();
                            System.out.println("RequestID " + requestId);
                            request.setRequestId(requestId);
                        }
                        break;

                    case "item-count:":
                        if (serverResponse.length() > 11) {
                            String itemCount = serverResponse.substring(11).trim();
                            System.out.println("Item Count: " + itemCount);
                        }
                        break;
            
                    case "budget:":
                        if (serverResponse.length() > 7) {
                          String budgetString = serverResponse.substring(7).trim();
                            budget = Double.parseDouble(budgetString);
                            System.out.println("Budget: $" + budget);
                            
                       
                        break;}
            
                    case "prod_start":
                    product = new Product(null, null, null, null);
                        break;
            
                    case "prod_id":
                        if (arrayStrings.length > 1 && arrayStrings[1].length() > 0) {
                            String productId = arrayStrings[1].trim();
                            if (product != null) {
                                product.setProductId(productId);
                        }
                    }
                        break;
            
                    case "title":
                        if (arrayStrings.length > 1 && arrayStrings[1].length() > 0) {
                            String itemTitle = arrayStrings[1].trim();
                            product.setTitle(itemTitle);
                        }
                        break;
            
                    case "price":
                        if (arrayStrings.length > 1 && arrayStrings[1].length() > 0) {
                            String itemPrice = arrayStrings[1].trim();
                            double price = Double.parseDouble(itemPrice);
                            product.setPrice(price);
                        }
                        break;
            
                    case "rating":
                        if (arrayStrings.length > 1 && arrayStrings[1].length() > 0) {
                            String itemRating = arrayStrings[1].trim();
                            double rating = Double.parseDouble(itemRating);
                            product.setRating(rating);
                        }
                        break;
            
                    case "prod_end":
                        productList.add(product);
                        break;
               }

                Collections.sort(productList, Comparator
                        .comparing(Product::getRating, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Product::getPrice, Comparator.nullsLast(Comparator.naturalOrder())));

                System.out.println("Sorted Products:");
                for (Product sortedProduct : productList) {
                    System.out.println(sortedProduct);
                }

                List<Product> selectedProducts = selectProducts(productList, budget);
                System.out.println("Selected Products:");
                double spent = 0;
                for (Product selectedProduct : selectedProducts) {
                    System.out.println(selectedProduct);
                    spent += selectedProduct.getPrice();
                }
    
                double remaining = budget - spent;
                System.out.println("Remaining budget: $" + remaining);
    

            }

    while (!stop) {
         String line = cons.readLine();
         line = line.trim() + "\n";

         Request productRequest = new Request();
        // productRequest.setRequestId(serverResponse.getRequestId(request));
         productRequest.setName("Name");
         productRequest.setEmail("gmail");
         //productRequest.setItems();
         productRequest.setSpent(budget);
         productRequest.setRemaining(budget);


      
        bufferedWriter.write("request_id:");
        bufferedWriter.write("name : ");
        bufferedWriter.write("email:");
        bufferedWriter.write("items: " + selectProducts(productList, budget));
        bufferedWriter.write("spent: %.2f\n");
        bufferedWriter.write("semaining: %.2f\n");
        bufferedWriter.write("client_end");

    } 


    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Product> selectProducts(List<Product> productList, double budget) {
        List<Product> selectedProducts = new ArrayList<>();
        double remainingBudget = budget;
    
        for (Product product : productList) {
            if (product.getPrice() <= remainingBudget) {
                selectedProducts.add(product);
                remainingBudget -= product.getPrice();
                System.out.println(remainingBudget);
                
            }
        }
    
        return selectedProducts;
    }

    
}
    


         
           
          
          
          
           
         
                  
          
                
              

            
        
        
    
           
 

