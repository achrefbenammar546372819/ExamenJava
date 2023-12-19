package Application.Interface;

import java.util.List;
import java.util.Scanner;
import Application.Account.*;
import Application.Interface.*;
import Application.product.*;
import java.util.Map;

public class UserInterface {
    static boolean run = true ; 
    Map<Product,Integer> Cart ; 

    public void  run_interface(){
        System.out.println("Welcome User");
        while (UserInterface.run){
            System.out.println("Menu"); 
            System.out.println("1->Add Product to Cart");
            System.out.println("2->Remove Product from Cart");
            System.out.println("3->Empty cart");
            Scanner sc = new Scanner(System.in); 
            int choice = sc.nextInt();
            run_on_choice(choice); 

        
        }
    }

    public void run_on_choice(int choice){
        switch (choice) {
            case 1:
                this.add_product_cart(); 
                break;
            case 2:
                this.remove_product_cart();
                break;
            case 3:
                this.empty_cart();
                break;
            default:
                break;
        }
    }


    public void add_product_cart(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID OF PRODUCT TO ADD TO CART ,Type [EXIT] TO EXIT");
        String in = sc.nextLine();
        if (in.equals("EXIT")){
            return;
        }
        else {
            Product p = ProductManager.find_product(in); 
            System.out.println("Number of items to add : ");
            int n = sc.nextInt(); 
            this.Cart.put(p, n); 
        }
    }

    public void remove_product_cart(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID OF PRODUCT TO REMOVE FROM CART ,Type [EXIT] TO EXIT");
        String in = sc.nextLine();
        if (in.equals("EXIT")){
            return;
        }
        else {
            Product p = ProductManager.find_product(in); 
            this.Cart.remove(p);  
        }
    }

    public void empty_cart(){
        this.Cart.clear();
    }



}
