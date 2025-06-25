import java.util.*;
class login{
     Map<String,Integer> users=new HashMap<>();
    void  log(){
         Scanner sc=new Scanner(System.in);
        
        System.out.println("create username and password");
        System.out.println("make sure that password is only of numeric numbers");
        System.out.print("enter the username: ");
        String user=sc.nextLine();
        
        if(users.containsKey(user))
        {
            System.out.println("the username already exists try different username");
            return;
        }
        System.out.print("enter the password:");
        int pass=sc.nextInt();
        
            users.put(user,pass);  

            System.out.println("account created successfully");
    }
    void signin()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the username: ");
        String user=sc.nextLine();
        System.out.print("enter the password: ");
        int pass=sc.nextInt();
        if(users.containsKey(user) && users.containsValue(pass))
        {
            System.out.println("----LOGGED IN SUCCESSFULLY----");
        }
        else{
            System.out.println("username or password is wrong");
        }
    }
}
public class admin{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        login lobj=new login();
        while(true){
        System.out.println("1.create an account 2.already have an account");
        int n=sc.nextInt();
        switch (n) {
            case 1:
                lobj.log();
                
                break;
            case 2:
            lobj.signin();
            break;
            default:
                System.out.println("choose the correct option");
        }
    }
}
}