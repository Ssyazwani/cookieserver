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

            Console cons = System.console();
            List<Product> productList = new ArrayList<>();
             List<Product> productsToAdd = new ArrayList<>();
            double budget = 0;  // Initialize the budget
            Product product = null;
            int itemCount = 0;
            String serverResponse;
            String requestId = "";
            double spent = 0;
            double remaining = 0;
            String response = "";

            while ((serverResponse = bufferedReader.readLine()) != null) { // while productList.size() = ItemCount
                //System.out.println(serverResponse);

                String[] arrayStrings = serverResponse.split(":");

                switch (arrayStrings[0]) {
                    case "request_id":
                        if (serverResponse.length() > 15) {
                            requestId = serverResponse.substring(14).trim();
                          //  System.out.println("RequestID " + requestId);
                        }
                        break;

                    case "item_count":
                        if (serverResponse.length() > 11) {
                            String countItem = serverResponse.substring(11).trim();
                            itemCount = Integer.parseInt(countItem);
                           // System.out.println("Item Count: " + itemCount);
                        }
                        break;

                    case "budget":
                        if (serverResponse.length() > 7) {
                            String budgetString = serverResponse.substring(7).trim();
                            budget = Double.parseDouble(budgetString);
                           // System.out.println("Budget:" + budget);
                        }
                        break;

                    case "prod_start":
                        product = new Product(null, null, null, null);
                        break;

                    case "prod_id":
                        if (serverResponse.length() > 7) {
                            String productId = arrayStrings[1].trim();
                            if (product != null) {
                                product.setProductId(productId);
                            }
                        }
                        break;

                    case "title":
                        if (serverResponse.length() > 6) {
                            String itemTitle = arrayStrings[1].trim();
                            product.setTitle(itemTitle);
                        }
                        break;

                    case "price":
                        if (serverResponse.length() > 6) {
                            String itemPrice = arrayStrings[1].trim();
                            double price = Double.parseDouble(itemPrice);
                            product.setPrice(price);
                        }
                        break;

                    case "rating":
                        if (serverResponse.length() > 7) {
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
                   spent = 0;

             for (Product selectedProduct : selectedProducts) {
             spent += selectedProduct.getPrice();
            remaining = budget - spent;
            if (selectedProduct.getPrice() <= remaining) {
              productsToAdd.add(selectedProduct);
            System.out.println("Product added: ");
             } else {
            System.out.println("Stop");
            System.out.println("List of products added:");
          for (Product addedProduct : productsToAdd) {
            System.out.println(addedProduct);

            break;
        }
    
        System.out.println("Remaining budget: $" + remaining);
        System.out.println("Spent: $" + spent);

        boolean stop = false;

            while (!stop) {
                response = "request_id: " + requestId + "\n" +
                        "name: Siti Syazwani\n" +
                        "email: sitisyazwanibtemaziz@gmail.com\n" +
                        "items: " + buildProductIds(productsToAdd) + "\n" +
                        "spent: " + spent + "\n" +
                        "remaining: " + remaining + "\n" +
                        "client_end\n";

                
                bufferedWriter.write(response);
                bufferedWriter.flush();

                String serverResponseStatus;

                while ((serverResponseStatus = bufferedReader.readLine()) != null) {
                    if (serverResponseStatus.equals("success") || serverResponseStatus.equals("failed")) {
                        System.out.println(serverResponseStatus);
                    }
                }
            }


    }
}


            }

            

            

        } catch (IOException e) {
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

    private static String buildProductIds(List<Product> selectedProducts) {
        StringBuilder builder = new StringBuilder();
        for (Product product : selectedProducts) {
            builder.append(product.getProductId()).append(",");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}