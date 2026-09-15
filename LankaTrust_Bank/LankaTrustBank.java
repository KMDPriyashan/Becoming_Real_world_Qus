import java.util.Scanner;

public class LankaTrustBank {
    
    static String[] usernames = { "kamal", "amara", "ranil" };
    static int[] pins = { 3221, 4567, 9090 };
    static double[] balance = {25000.00,75000.00,8400.75};
    static String userName;
    static int pinNumber;
    static int user;

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean isLoggedIn = false;   // ✅ success track කරන්න flag එකක්

        outer:
        for (int a = 0; a < 3; a++) {

            System.out.print("Enter the username: ");
            userName = scan.nextLine();

            System.out.print("Enter the PIN Number: ");
            pinNumber = scan.nextInt();
            scan.nextLine();   // leftover newline consume

            for (int x = 0; x < pins.length; x++) {
                if (usernames[x].equals(userName) || pinNumber == pins[x]) {
                    user = x;
                    System.out.println("Username and password is Correct. Welcome to LankaTrust Bank...!");
                    isLoggedIn = true;
                    break outer;
                }
            }

            System.out.println("Please enter the correct Username and password..!");
        }

        // 
        if (isLoggedIn) {
            System.out.println("Thank you for banking with us!");
            mainManu();

        } else {
            System.out.println("System is locked..! Please try again later....");
        }

        scan.close();
    }

    public static void mainManu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Mini Statement");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");

        System.out.println("Enter Your Chooces : ");
        int choise = scan.nextInt();

        switch (choise) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrowMoney();
                break;
            case 4:
                miniStatment();
                break; 
            case 5:
                changePin();
                break;     
            default:
                System.out.println("Thank You For Comming..!, See You again...");
                break;
        }
    }

    public static void checkBalance(){
        for(int x=0;x<usernames.length; x++){
            if(usernames[x].equals(userName)){
                System.out.println(userName+" 'S Account balance is : "+balance[x]);
            }
        }
    }

    public static void depositMoney(){
        System.out.println("enter the deposite ammount: ");
        String amountString = scan.nextLine();
        double amount = Double.parseDouble(amountString);

        if(amount > 0 || amount <= 1000000){
            balance[user]=balance[user]+amount;
            System.out.println("Your Now Account Blance : "+ (int)balance[user]);
        }
        
    }
    public static void withdrowMoney(){
        //must be start
    }
    public static void miniStatment(){
        
    }
    public static void changePin(){
        
    }
}