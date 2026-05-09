public class BankAccount {

    int accountNumber;
    String accountHolderName;
    double balance;

    public void setAccountDetails(int accNo, String name, double initialBalance){

        accountNumber = accNo;
        accountHolderName = name;
        balance = initialBalance;

    }

    public void displayAccountDetails(){
        System.out.println("Account No. = " +accountNumber);
        System.out.println("Account Holder Name = " +accountHolderName);
        System.out.println("Initial Balance in " +accountNumber + " = " +balance);
    }

    public static void main(String[] args) {

        BankAccount details = new BankAccount();
        details.setAccountDetails(7841578,"Ansen Disusa fernandas",12578.254);
        details.displayAccountDetails();

    }

    }


