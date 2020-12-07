/**
 * @Authors: Gabriel Dietrich (100764733) and Fleur Blanckaert (100747083)
 * @Date: Dec 06, 2020
 * @Program: OOP3200 - Java Lab 3
 * @Description: This is extension of the WorkTicket class in which it basically
 *               inherits all attributes from WorkTicket and indicates if the WorkTicket
 *               is opened or not.
 */

package ca.durhamcollege;

public class ExtendedWorkTicket extends WorkTicket
{
    //PRIVATE INSTANCE VARIABLES
    private boolean myOpen;

    //PUBLIC PROPERTIES
    public boolean isOpen()
    {
        return myOpen;
    }

    public void setOpen(boolean open)
    {
        myOpen = open;
    }

    //MUTATORS
    public boolean openTicket()
    {
        return myOpen;
    }

    public boolean closeTicket()
    {
        return false;
    }

    //CONSTRUCTORS
    // Default constructor
    ExtendedWorkTicket()
    {
        super();
        myOpen = true;
    }

    // Parameterized constructor
    ExtendedWorkTicket(int number, String id, int day, int month, int year , String description, boolean isOpen)
    {
        super.SetWorkTicket(number, id, day, month, year, description);
        setOpen(isOpen);
    }

    // Override Parameterized constructor that is accepting a WorkTicket object to also accept boolean isOpen
    ExtendedWorkTicket(WorkTicket ticket, boolean isOpen)
    {
        super(ticket);
        setOpen(isOpen);
    }

    // Overloaded SetWorkTicket, including parameter myOpen
    public boolean SetWorkTicket(int number, String id, int day, int month, int year, String description, boolean isOpen)
    {
        boolean isValid = true;

        if (myOpen == true)
        {
            super.SetWorkTicket(number, id, day, month, year, description);
            isOpen = openTicket();
            isValid = true;

        }
        else
        {
            isOpen = closeTicket();
            isValid = false;
        }
        return isValid;

    }
    @Override
    public String toString() {
        String out = super.toString();

        if (isOpen() == true)
        {
            out += "\nTicket:            Open";
        }
        else
        {
            out += "\nTicket:            Close";
        }

        return out;
    }
}
