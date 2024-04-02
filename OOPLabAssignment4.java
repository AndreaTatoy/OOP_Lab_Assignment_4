import java.util.Scanner;

public class OOPLabAssignment4 {
    public static class MaxLogInException extends Exception{
        public MaxLogInException(String message){
            super(message);
        }
    }

    public static class InvalidPasswordException extends Exception{
        public InvalidPasswordException(String message){
            super(message);
        }
    }

    public class LogInValidator{
        private static final String PASSWORD = "password";
        private static int loginAttempts = 0;
        private static final int MAX_ATTEMPTS = 3;

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            System.out.print("\n\nWelcome, dear user!");
            boolean loggedIn = false;

            while (!loggedIn){
                if (loginAttempts >= MAX_ATTEMPTS){
                    System.out.println("\nYou have reached the maximum numbers of login attempts. Please try again later.");
                    break;
                }

                System.out.print("\nPlease enter \"password\": ");
                String userInput = scan.nextLine();
               
                try {
                    logIn(userInput);
                    loggedIn = true;
                }
                catch (MaxLogInException | InvalidPasswordException e){
                    System.out.println(e.getMessage());
               }
            }
            scan.close();
        }

        public static void logIn(String password) throws MaxLogInException, InvalidPasswordException{
            if (loginAttempts >= MAX_ATTEMPTS) {
                throw new MaxLogInException("You have reached the maximum numbers of login attempts. Please try again later.");
            }
            else if (!PASSWORD.equals(password)){
                loginAttempts++;
                throw new InvalidPasswordException("Wrong password. Try again.");
            }
            else{
                System.out.print("\nLogin successful. Welcome!\n\n");
                loginAttempts = 0;
            }
        }
    }
}