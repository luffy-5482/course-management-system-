import java.util.*;

class AdminData {
    Map<String, Integer> students = new HashMap<>();
    Map<String, Integer> courses = new HashMap<>();
    Map<String, Integer> professors = new HashMap<>();
}

class Function {
    void func(AdminData data) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select the operation you want to perform:");
            System.out.println("1. Add student  2. Add course  3. Add professor");
            System.out.println("4. Display students  5. Display courses  6. Display professors  7. Exit");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    System.out.print("Enter the student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter the student ID: ");
                    int studentId = sc.nextInt();
                    data.students.put(studentName, studentId);
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter the course name: ");
                    String courseName = sc.nextLine();
                    System.out.print("Enter the course ID: ");
                    int courseId = sc.nextInt();
                    data.courses.put(courseName, courseId);
                    System.out.println("Course added.");
                    break;
                case 3:
                    System.out.print("Enter the professor name: ");
                    String professorName = sc.nextLine();
                    System.out.print("Enter the professor ID: ");
                    int professorId = sc.nextInt();
                    data.professors.put(professorName, professorId);
                    System.out.println("Professor added.");
                    break;
                case 4:
                    for (Map.Entry<String, Integer> entry : data.students.entrySet()) {
                        System.out.println("Student Name: " + entry.getKey() + "  Student ID: " + entry.getValue());
                    }
                    break;
                case 5:
                    for (Map.Entry<String, Integer> entry : data.courses.entrySet()) {
                        System.out.println("Course Name: " + entry.getKey() + "  Course ID: " + entry.getValue());
                    }
                    break;
                case 6: 
                    for (Map.Entry<String, Integer> entry : data.professors.entrySet()) {
                        System.out.println("Professor Name: " + entry.getKey() + "  Professor ID: " + entry.getValue());
                    }
                    break;
                case 7: 
                    return;
                default:
                    System.out.println("Enter the correct choice.");
            }
        }
    }
}

class Login extends Function {
    Map<String, Integer> users = new HashMap<>(); 
    Map<String, AdminData> adminStorage = new HashMap<>();

    void log() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create username and password");
        System.out.println("Make sure that password is only numeric numbers.");
        System.out.print("Enter the username: ");
        String user = sc.nextLine();

        if (users.containsKey(user)) {
            System.out.println("The username already exists. Try a different username.");
            return;
        }
        System.out.print("Enter the password: ");
        int pass = sc.nextInt();
        users.put(user, pass);
        adminStorage.put(user, new AdminData());
        System.out.println("Account created successfully.");
    }
    void signin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the username: ");
        String user = sc.nextLine();
        System.out.print("Enter the password: ");
        int pass = sc.nextInt();

        if (users.containsKey(user) && users.get(user) == pass) {
            System.out.println("----LOGGED IN SUCCESSFULLY----");
            func(adminStorage.get(user)); 
        } else {
            System.out.println("Username or password is wrong.");
        }
    }
}
public class admin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login lobj = new Login();

        while (true) {
            System.out.println("1. Create an account");
            System.out.println("2. Already have an account");
            System.out.println("3. Exit");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    lobj.log();
                    break;
                case 2:
                    lobj.signin();
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Choose the correct option.");
            }
        }
    }
}