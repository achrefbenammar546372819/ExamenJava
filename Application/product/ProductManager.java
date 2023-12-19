package Application.product;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Application.utils.CsvUtils;

public class ProductManager {
    static String filePath = "Data/Products/Products.csv";

    public static void create_add_product(){
        Product p = new Product();
        ProductManager.save_product(p);
    }

    public static void delete_product(String id ){
        
        int index = CsvUtils.find_index_line(Arrays.asList(id), filePath); 
        CsvUtils.removeLineFromCSV(index, filePath);
    }




    public static void save_product(Product p ){
        
        boolean product_alreadty_exists = ProductManager.check_product_exists(p);
        if (product_alreadty_exists == false){
            String [] data = {p.id , p.name, String.valueOf(p.whole_sale_price) , String.valueOf(p.unit_price) }; 
            CsvUtils.writeCSV(Arrays.asList(data) , filePath); 
        }
        else {
            System.out.println("The product you're trying to add Already Exists");

        }

    }

    protected static List<String> changename(List<String> data , String chganged_value){
        data.set(1 , chganged_value);
        return data ;
    }
    protected static List<String> changeunitprice(List<String> data, String chganged_value ){
        data.set(3 , chganged_value);
        return data ; 
    }
    protected static List<String> changewholeprice(List<String> data , String chganged_value){
        data.set(2 , chganged_value);
        return data ; 
    }



    public static void change_product(String id , String chganged_value ){
        int index = CsvUtils.find_index_line(Arrays.asList(id), filePath); 
        if (index>=0){
        List<List<String>> data = CsvUtils.readCSV(filePath); 
        Scanner scanner = new Scanner(System.in); 
        int choice = scanner.nextInt(); 
        System.out.println("1-change name \n2-change whole sale price \n3-change unit sale price \n");
        List<String> new_data ;
     
        switch (choice) {
            case 1:
                new_data = ProductManager.changename(data.get(index) , chganged_value);
                break;
            case 2:
                new_data = ProductManager.changewholeprice(data.get(index), chganged_value);
                break;
            case 3:
                new_data = ProductManager.changeunitprice(data.get(index), chganged_value);
                break;
            default:

                System.out.println("Invalid choice. Please choose a valid option.");
        }
        CsvUtils.removeLineFromCSV(index, filePath);
        String[] stringArray = data.toArray(new String[0]);
        CsvUtils.appendToCSV(stringArray , id);
    }
    else {
        System.out.println("Product id doesn't exist !!");
    }

    }



    protected static boolean check_product_exists(Product p ){
        List<String> data = Arrays.asList(p.id , p.name); 
        int index_line = CsvUtils.find_index_line(data, filePath);
        return index_line >= 0 ; 
    }

    public static  Product find_product(String id ){
        int index =  CsvUtils.find_index_line(Arrays.asList(id), filePath); 
        List<List<String>> data = CsvUtils.readCSV(filePath);
        List<String> Product_data = data.get(index); 

        Product p = new Product(Product_data.get(1), Product_data.get(2), Product_data.get(3));
        return p ; 
    }


}
