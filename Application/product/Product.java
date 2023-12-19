package Application.product;
import java.util.Scanner;
import Application.utils.Hasher;

public class Product {
    protected String id ; 
    protected String name ; 
    protected double whole_sale_price; 
    public double unit_price ; 

    public Product (){

        Scanner scanner = new Scanner(System.in); 

         //create user name of product and use that to create the id number 
        System.out.println("Product's Name : ") ; 
        this.name= scanner.nextLine(); 
        this.id = Hasher.hashString(name) ; 
        

        System.out.println("Whole sale price : ");
        this.whole_sale_price = scanner.nextDouble(); 

        System.out.println("Unit price : ");
        this.unit_price = scanner.nextDouble(); 


        

        
        
    }

    public Product(String name , String whole_sale_price , String unit_price){
        this.name = name ; 
        this.id = Hasher.hashString(name); 
        this.whole_sale_price = Double.parseDouble(whole_sale_price);
        this.unit_price = Double.parseDouble(unit_price); 
    }


}   