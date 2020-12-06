package ca.durhamcollege;

public class ExtentedWorkTicket extends WorkTicket
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

    public void closeTicket()
    {
        myOpen = false;
    }

    //CONSTRUCTORS
    ExtentedWorkTicket()
    {
        super();
        myOpen = true;
    }

    ExtentedWorkTicket(int number, String id, int day, int month, int year , String description, boolean isOpen)
    {
        super.SetWorkTicket(number, id, day, month, year, description);
        setOpen(isOpen);
    }

    ExtentedWorkTicket(WorkTicket ticket, boolean isOpen)
    {
        super(ticket);
        setOpen(isOpen);
    }

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
