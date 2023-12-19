package Application.Account;


import Application.utils.CsvUtils; 
import java.util.Arrays;
import java.util.List;






public class AccountManager {
    static String UserAccountsfilePath = "Data/Accounts/UserAccounts.csv";
    static String AdminAccountsfilePath = "Data/Accounts/AdminAccounts.csv";

    public static void create_user_account(){
        UserAccount a = new UserAccount(); 
        AccountManager.save_new_account(a , UserAccountsfilePath);
    }

    public static void create_admin_account(){
        AdminAccount a = new AdminAccount();
        AccountManager.save_new_account(a, AdminAccountsfilePath);
    }

    
    public static void save_new_account(Account a , String csv_file_path){
        String [] data = {String.valueOf(a.id) , a.user_name , a.hashed_password }; 
        CsvUtils.writeCSV(Arrays.asList(data) , csv_file_path); 
    }

    public static void delete_admin_account(Account a ){
        List<String> data = Arrays.asList(String.valueOf(a.id) , a.user_name , a.hashed_password);
        int index_line = CsvUtils.find_index_line(data , AdminAccountsfilePath); 
        if (index_line >= 0 ){
            CsvUtils.removeLineFromCSV(index_line, AdminAccountsfilePath);
        }
        

    }

    public static String find_account(Account a   ){
        List<String> login_data = Arrays.asList(String.valueOf(a.id) , a.user_name , a.hashed_password ); 
        int index_line = CsvUtils.find_index_line(login_data , AdminAccountsfilePath);   
        if (index_line >= 0 ){
            return "ADMIN_CONNECTED"; 
        }
        index_line = CsvUtils.find_index_line(login_data , UserAccountsfilePath); 
        if (index_line >= 0 ){
            return "USER_CONNECTED"; 
        }
        else {
            return "LOGIN_ERROR"; 
        }
    }

    public static void delete_user_account(Account a ){
        List<String> data = Arrays.asList(String.valueOf(a.id) , a.user_name , a.hashed_password);
        int index_line = CsvUtils.find_index_line(data , UserAccountsfilePath);
        if (index_line >= 0 ){
            CsvUtils.removeLineFromCSV(index_line, UserAccountsfilePath);

        } 
    }

    public static void delete_account(){
        Account a = new Account();
        delete_admin_account(a);
        delete_user_account(a); 
    }



   






    


}
