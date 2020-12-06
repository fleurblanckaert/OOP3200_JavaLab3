/**
 * @Authors: Gabriel Dietrich (100764733) and Fleur Blanckaert (100747083)
 * @Date: Dec 06, 2020
 * @Program: OOP3200 - Java Lab 3
 * @Description: This application creates a class called WorkTicket, which represents the client's
 * 				request for IT support.	The class is then extended to ExtendedWorkTicket, which
 * 			    indicates if the ticket is opened or closed. This part prompts the user to enter
 * 			    parameters and then displays then.
 */


package ca.durhamcollege;
import java.time.DateTimeException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        // Declarations
        ExtendedWorkTicket ticket1 = new ExtendedWorkTicket(12, "Hello", 12, 12, 2020, "Error", true);
        ExtendedWorkTicket ticket2 = new ExtendedWorkTicket();
        ExtendedWorkTicket ticket3 = new ExtendedWorkTicket(ticket1, false);

        int ticketInput = 0;
        String clientInput = "";
        int dayInput = 0;
        int monthInput = 0;
        int yearInput = 0;
        String endApplication = "";
        String descriptionInput = "";
        boolean isValid = true;
        int i = 1;


        // Output Header
        System.out.println("\n=====================================");
        System.out.println("IT Support Application: Constructors");
        System.out.println("=====================================\n");

        // Display ExtendedWorkTicket constructors
        System.out.println("\nThe Parameterized constructor" + ticket1.toString());
        System.out.println("\nThe Parameterized constructor that accepts an object" + ticket3.toString());
        System.out.println("\nThe Default constructor" + ticket2.toString());


        do {
            try {
                // Output Header
                System.out.println("\n=====================================");
                System.out.println("\tIT Support Application: Entry " + i );
                System.out.println("=====================================\n");

                Scanner keyboard = new Scanner(System.in);
                //Prompts user to enter ticket ID
                System.out.print("The Ticket Number is: ");
                ticketInput = keyboard.nextInt();
                keyboard.nextLine();

                // Call function to Validate Ticket
                ticket1.ValidateTicket(ticketInput);

                //Prompts user to enter ticket day
                System.out.println("The Work Ticket Date is: ");
                System.out.print("Day: ");
                dayInput = keyboard.nextInt();

                //Prompts user to enter ticket month
                System.out.print("Month: ");
                monthInput = keyboard.nextInt();

                //Prompts user to enter ticket year
                System.out.print("Year: ");
                yearInput = keyboard.nextInt();
                keyboard.nextLine();

                // Calls Function to Validate Date
                ticket1.ValidateDate(dayInput, monthInput, yearInput);

                //Prompts user to enter client id
                System.out.print("The Client ID is: ");
                clientInput = keyboard.nextLine();

                //Prompts user to enter ticket description
                System.out.print("The Issue Description is: ");
                descriptionInput = keyboard.nextLine();

                // Displays the output
                ticket1.SetWorkTicket(ticketInput, clientInput, dayInput, monthInput, yearInput, descriptionInput);
                System.out.println(ticket1.toString());

                System.out.print("\nIf you would like to exit the application, enter END:" +
                        " ");
                endApplication = keyboard.nextLine();

                if(endApplication.equals("END"))
                {
                    break;
                }
                else
                {
                    isValid = false;
                    i++;
                }

            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("Exception occurred: " + illegalArgumentException.getMessage());
                isValid = false;

            } catch (DateTimeException dateTimeException) {
                System.out.println("Exception occurred: " + dateTimeException.getMessage());
                isValid = false;
            }

        }
        while(!isValid);

    }
}
