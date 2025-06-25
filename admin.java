import java.util.*;
class function{
    Map<String,Integer> student=new HashMap<>();
    Map<String,Integer> course=new HashMap<>();
    Map<String,Integer> professor=new HashMap<>();
    void stud(){
        Scanner sc = new Scanner(System.in);
        String name;
        int stdid;
        System.out.print("enter the student name: ");
        name=sc.nextLine();
        System.out.print("enter the student id: ");
        stdid=sc.nextInt();
        student.put(name,stdid);
        System.out.println("student added");
    }
    void course(){
        Scanner sc = new Scanner(System.in);
        String name;
        int stdid;
        System.out.print("enter the course name: ");
        name=sc.nextLine();
        System.out.print("enter the course id: ");
        stdid=sc.nextInt();
        course.put(name,stdid);
        System.out.println("course added ");
    }
    void prof(){
        Scanner sc = new Scanner(System.in);
        String name;
        int stdid;
        System.out.print("enter the professor name: ");
        name=sc.nextLine();
        System.out.print("enter the professor id: ");
        stdid=sc.nextInt();
        professor.put(name,stdid);
        System.out.println("professor added");
    }
    void func(){
        
        int n;
        Scanner sc=new Scanner(System.in);
        while (true) { 
            System.out.println("select what operation you want to perform");
            System.out.println("1.add student 2.add courses 3.add professor 4.display students 5.display course 6.display professor 7.exit");
            n=sc.nextInt();
            switch(n){
                case 1:
                    stud();
                    break;
                case 2:
                    course();
                    break;
                case 3:
                    prof();
                    break;
                case 4:
                    {
                        for(HashMap.Entry<String,Integer> stud : student.entrySet())
                             {
                                System.out.println("student name:"+stud.getKey()+"student id"+stud.getValue());
                             }
                    }
                    break;
                case 5:
                    {
                        for(HashMap.Entry<String,Integer> crs : course.entrySet())
                             {
                                System.out.println("student name:"+crs.getKey()+"student id"+crs.getValue());
                             }
                    }
                    break;
                case 6:
                    {
                        for(HashMap.Entry<String,Integer> prf : professor.entrySet())
                             {
                                System.out.println("student name:"+prf.getKey()+"student id"+prf.getValue());
                             }
                    }
                    break;
                default:
                System.out.println("enter the correct choice");
            }
        }
    }
        
}
class login extends function{
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
        System.out.print("enter the password: ");
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
            func();
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
        System.out.println("1.create an account "+"\n"+"2.already have an account"+"\n"+"3.exit");
        int n=sc.nextInt();
        switch (n) {
            case 1:
                lobj.log();
                break;
            case 2:
                lobj.signin();
                 break;
            case 3:
                return;
            default:
                System.out.println("choose the correct option");
        }
    }
}
}