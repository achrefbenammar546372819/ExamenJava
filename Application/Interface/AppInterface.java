package Application.Interface;

import java.util.Scanner;

import Application.Account.*; 

public class AppInterface {
    public boolean run ; 


    public AppInterface(){
        this.run = true; 
    }


    public boolean console_in(){
        Scanner scanner = new Scanner (System.in); 
        System.out.println("Continue with the App [Y]or[N] :"); 
        String input_string  ; 
        input_string = scanner.nextLine(); 
        if (input_string.equals('Y')){
            return true ; 
        }
        else {
            return false ; 
        }
    }
    
    public void run_app(){
        boolean run = true ; 
        while(run){
            this.console_in();
            System.out.println("1->Connect Account \n2->Create User Account"); 
            Scanner sc = new Scanner(System.in); 
            int choice = sc.nextInt();
            if (choice == 1 ){
                this.User_authentification(); 
            }
            else if (choice == 2 ){
                AccountManager.create_user_account(); 
                this.User_authentification(); 
            }
            
        }
    }

    public void User_authentification(){
        Account account = new Account();
        String login_state = AccountManager.find_account(account); 
        if (login_state.equals("ADMIN_CONNECTED")){
            AdminInterface a_interface = new AdminInterface(); 
            a_interface.run_interface();
        }
        else if (login_state.equals("USER_CONNECTED")){
            UserInterface u_interface = new UserInterface(); 
            u_interface.run_interface(); 
        }
        else if (login_state.equals("LOGIN_ERROR")){
            this.run = false ; 
            System.out.println("LOGIN_ERROR"); 
        }

    }
}