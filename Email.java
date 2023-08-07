import java.util.Scanner;


public class Email{
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength = 10;
    private int mailCapacity = 500;
    private String altEmail;
    private String email;
    private String companySuffix  = "aeycompany.com";


    public Email(String first, String last){
        this.firstName = first;
        this.lastName = last;

        // call a method asking for the department - return the department 
        this.department = setDepartment();
       

        //call a method that returns a random password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
      
    }

    private String setDepartment(){
        System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "sales";
        }
        else if(depChoice == 2){
            return "development";
        }
        else if(depChoice == 3){
            return "accounting";
        }
        else{
            return "none";
        }
    }

    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
            System.out.println(rand);
            System.out.println(passwordSet.charAt(rand));
        }
        return new String(password);
    }

    public void changePassword(String change){
        this.password = change;
    }

    public void setMailCapacity(int limit){
        this.mailCapacity = limit;
    }
    public void setAltEmail(String altEmail){
        this.altEmail = altEmail;
    }
    public int getMailboxCapacity(){
        return mailCapacity;
    }
    public String getAltEmail(){
        return altEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
        "\nCOMPANY EMAIL: " + email +
        "\nMAILBOX CAPACITY: " + mailCapacity;

    }
}