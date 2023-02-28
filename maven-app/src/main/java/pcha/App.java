package pcha;
import java.util.*;

     /*
     * ChavviCalc complete code
     */
    public class App {

        static float A = 0f;
        static float B = 0f;
        public static void main(String[] args) {
      
          
      
          Scanner scan = new Scanner(System.in);
          Character command = '_';
      
          // allow the user to use the clalulator as long as q is not entered as a command
          while (command != 'q') {
            printMenu();
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan);
      
            executeCommand(scan, command);
          }
      
          scan.close();
        }
      
       
        // menu functions
     
        private static void printMenuLine() {
          System.out.println(
            "----------------------------------------------------------"
          );
        }
      
        private static void printMenuCommand(Character command, String desc) {
          System.out.printf("%s\t%s\n", command, desc);
        }
      
        // Menu printing code
        public static void printMenu() {
          printMenuLine();
          System.out.println("ChavviCalc");
          printMenuLine();
          
          System.out.print("A = ");
          System.out.print(String.format("%.3f", A));
          System.out.print("\tB = ");
          System.out.println(String.format("%.3f", B));
      
          printMenuLine();
      
          printMenuCommand('a', "Enter a value for A");
          printMenuCommand('b', "Enter a value for B");
          printMenuCommand('+', "Add");
          printMenuCommand('-', "Subtract");
          printMenuCommand('*', "Multiply");
          printMenuCommand('/', "Divide");
          printMenuCommand('c', "Clear");
          printMenuCommand('q', "Quit");
      
          printMenuLine();
        }
      
        // getting the fisrt value from the user input
        private static Character menuGetCommand(Scanner scan) {
          Character command = '_';
      
          String rawInput = scan.nextLine();
      
          if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
          }
      
          return command;
        }
      
        // Assigning the functions to their signs
        private static Boolean executeCommand(Scanner scan, Character command) {
            Boolean success = true;
          
            switch (command) {
              case 'q':
                System.out.println("Thank you for using Chavvi Calc");
                break;
              case 'a':
                System.out.print("Enter value for 'a': ");
                if (scan.hasNextFloat()) {
                  A = scan.nextFloat();
                } else {
                  System.out.println("ERROR: Enter a valid number(3 decimal places for fractions)");
                }
                scan.nextLine();
                break;
              case 'b':
                System.out.print("Enter value for 'b': ");
                if (scan.hasNextFloat()) {
                  B = scan.nextFloat();
                } else {
                  System.out.println("ERROR: Enter a valid number(3 decimal places for fractions)");
                }
                scan.nextLine();
                break;
              case '+':
                A = A + B;
                System.out.printf("%.3f %c %.3f = %.3f", A, '+', B, A + B);
                break;
              case '-':
                A = A - B;
                System.out.printf("%.3f %c %.3f = %.3f", A, '-', B, A - B);
                break;
              case '*':
                A = A * B;
                System.out.printf("%.3f %c %.3f = %.3f", A, '*', B, A * B);
                break;
              case '/':
                if (B == 0) {
                  System.out.println("ERROR: Unable to divide by 0");
                  break;
                }
                A = A / B;
                System.out.printf("%.3f %c %.3f = %.3f", A, '/', B, A / B);
                break;
              case 'c':
                A = 0;
                B = 0;
                break;
              default:
                System.out.println("ERROR: Unknown command");
                success = false;
            }
            
            return success;
          }         
      
      }
      