package banking;

import java.util.Random;
import java.util.Scanner;

public class Main {

    protected static UserAccount[] userAccounts = new UserAccount[100]; //would want to use an arraylist here, but for course to pass i need array
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        String userInput;

        String output = "1. Create an account" +
                "\n" +
                "2. Log into account" +
                "\n" +
                "0. Exit";
        System.out.println(output);

        int action = 1;
        System.out.print(">");
        userInput = myObj.nextLine();


        while (!userInput.equals("0")) {
            switch (action){
                case 1:
                    if (userInput.equals("1")) {

                        for (int i = 0; i < userAccounts.length; i++) {
                            if (userAccounts[i] == null) {
                                UserAccount newAccount = new UserAccount();
                                userAccounts[i] = newAccount;
                                System.out.println("Your card has been created");
                                System.out.println("Your card number:" + "\n" + newAccount.getCardNumber());
                                System.out.println("Your card pin:" + "\n" + newAccount.getCardPin());
                                break;
                            }
                        }
                    }
                    else{ //log into account
                        System.out.println("Enter your card number:");
                        System.out.print(">");
                        long userCardNumber = Long.parseLong(myObj.nextLine());

                        System.out.println("Enter your card sim:");
                        System.out.print(">");
                        int userPin = Integer.parseInt(myObj.nextLine());

                        for (int i = 0; i < userAccounts.length; i++){
                            UserAccount currentLoopUser = userAccounts[i];
                            if (userAccounts[i] == null){
                                System.out.println("No such account");
                            }
                            else{
                                if (userCardNumber == currentLoopUser.getCardNumber()){
                                    if (userPin == currentLoopUser.getCardPin()){
                                        action = 2;
                                        System.out.println("You have successfully logged in!");
                                        output = "1. Balance" +
                                                "\n" +
                                                "2. Log out" +
                                                "\n" +
                                                "0. Exit";
                                        break;
                                    }
                                    else{
                                        System.out.println("Wrong card number or PIN!");
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    if (userInput.equals("1")) {
                        for (int i = 0; i < userAccounts.length; i++) {
                            if (userAccounts[i] != null) {
                                UserAccount newAccount = new UserAccount();
                                userAccounts[i] = newAccount;
                                System.out.println("Balance: " + 0);
                            } else {
                                break;
                            }
                        }
                    }
                    else{ //log out
                        System.out.println("You have successfully logged out!");
                        action = 1;
                        output = "1. Create an account" +
                                "\n" +
                                "2. Log into account" +
                                "\n" +
                                "0. Exit";
                    }

                    break;

            }
            System.out.println(output);
            System.out.print(">");
            userInput = myObj.nextLine();

            }
        System.out.println("Bye!");
    }

    public static class UserAccount {
        Random random = new Random();
        protected long cardNumber;
        protected int cardPin;

        public UserAccount() {
            long cardNumEnd = random.nextLong(10000000000L);
            this.cardNumber = Long.valueOf("400000" + Long.toString(cardNumEnd));
            this.cardPin = random.nextInt(9000) + 1000;
        }

        public Long getCardNumber() {
            return cardNumber;
        }

        public int getCardPin() {
            return cardPin;
        }
    }

}


