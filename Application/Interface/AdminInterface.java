package Application.Interface;

import java.util.Scanner;

import Application.Account.AccountManager;
import Application.product.ProductManager;

public class AdminInterface {
    public void run_interface (){
        System.out.println("Welcome Admin");
        while (true ){
            
            System.out.println("Menu"); 
            System.out.println("1->Add Product");
            System.out.println("2->Remove Product");
            System.out.println("3->Change Product");
            System.out.println("4->Delete Account");
            Scanner sc = new Scanner(System.in); 
            int choice = sc.nextInt();
            String in; 
            switch (choice) {
                case 1:
                    ProductManager.create_add_product(); 
                    break;
                case 2: 
                    System.out.println("ID OF PRODUCT TO DELETE ,Type [EXIT] TO EXIT");
                    in = sc.nextLine();
                    if (in.equals("EXIT")){
                        break ; 
                    }
                    
                    ProductManager.delete_product(in); 
                    break ; 
                case 3 :
                    System.out.println("ID OF PRODUCT TO EDIT ,Type [EXIT] TO EXIT");
                    in = sc.nextLine();
                    if (in.equals("EXIT")){
                        break ; 
                    }
                    System.out.println("NEW VALUE ,Type [EXIT] TO EXIT");
                    String new_value = sc.nextLine(); 
                    
                    ProductManager.change_product(in, new_value);                     
                    break ;
                case 4 :      
                    AccountManager.delete_account()  ;            
                    break ;  
                default:
                    break;
            }

        }
    }    
}
