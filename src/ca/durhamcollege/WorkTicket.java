/**
 * @Authors: Gabriel Dietrich (100764733) and Fleur Blanckaert (100747083
 * @Date: Nov 21, 2020
 * @Program: OOP3200 - Java Lab 2
 * @Description: This application creates a class called WorkTicket, which represents the client's
 *              request for IT support. We display all the object's attributes with a ToString method
 *              and validate the data entered by the user, using exception handling in some cases.
 */
package ca.durhamcollege;
import java.time.DateTimeException;
import java.time.LocalDate;

public class WorkTicket {
    // Private instance variables
    protected int ticketNumber;
    protected String clientId;
    protected LocalDate ticketDate;
    protected String issueDescription;

    // Public properties
    // Accessors
    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    // Mutators
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ValidateTicket(ticketNumber);
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setTicketDate(int day, int month, int year) {
        //Formats Date
        if (ValidateDate(day, month, year) == true) {
            LocalDate ticketDate = LocalDate.of(year, month, day);
            this.ticketDate = ticketDate;
        }
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    // Mutator Method
    public void SetWorkTicket(int number, String id, int day, int month, int year, String description) {
        setTicketNumber(number);
        setClientId(id);
        setTicketDate(day, month, year);
        setIssueDescription(description);
    }

    // Default constructor
    public WorkTicket() {
        ticketNumber = 0;
        clientId = null;
        ticketDate = null;
        issueDescription = null;
    }

    // Parameterized constructor
    WorkTicket(int number, String id, int day, int month, int year, String description) {
        SetWorkTicket(number, id, day, month, year, description);
    }

    public WorkTicket(WorkTicket ticket)
    {
        this.ticketNumber = ticket.ticketNumber;
        this.clientId = ticket.clientId;
        this.issueDescription = ticket.issueDescription;
        this.ticketDate = ticket.ticketDate;
    }

    // Returns string that shows object's attributes
    @Override
    public String toString()
    {
        return "\nTicket #:           " + ticketNumber +
                "\nClient ID:         " + clientId +
                "\nWork Ticket Date:  " + ticketDate +
                "\nIssue Description: " + issueDescription;

    }


    // Function that reads integer values
    public int ValidateTicket(int ticket)
    {
        int MIN_NUM = 1;
        if(ticket < 1 )
        {
            throw new IllegalArgumentException("Please enter a whole, positive number\n");
        }
        else
        {
            return (int)ticket;
        }

    }
    public boolean ValidateDate(int day, int month, int year)
    {
        int MIN_AMOUNT = 1;
        int MAX_DAY = 31;
        int MAX_MONTH = 12;
        int MIN_YEAR = 2000;
        int MAX_YEAR = 2099;
        if(day < MIN_AMOUNT || day > MAX_DAY)
        {
            throw new DateTimeException("Day must be between " + MIN_AMOUNT + " and " + MAX_DAY + "\n");
        }
        else if(month < MIN_AMOUNT || month > MAX_MONTH)
        {
            throw new DateTimeException("\nDay must be between " + MIN_AMOUNT + " and " + MAX_MONTH + "\n");
        }
        else if(year < MIN_YEAR || year > MAX_YEAR)
        {
            throw new DateTimeException("\nYear must be at least between " + MIN_YEAR + " and " + MAX_YEAR + "\n");
        }
        else
        {
            return true;
        }
    }
}