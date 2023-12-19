package Application.Account;


import java.util.Scanner;
import Application.utils.Hasher;
public class Account {
    
    protected String hashed_password; 
    protected String user_name ;
    protected int id ; 
   


    public Account(){
        Scanner scanner = new Scanner(System.in) ; 

        

        //create user name of customer 
        System.out.println("Enter User Name : ") ; 
        this.user_name = scanner.nextLine(); 

        //create password and store it hashed 
        System.out.println("Enter password : ") ; 
        String password = scanner.nextLine() ;
        this.hashed_password = Hasher.hashString(password); 


       


        //user id 
        this.id = user_name.hashCode(); 



    }


    


    




    
}


