import java.util.Calendar;
import java.util.Objects;


/**
 * @author Matt Bennett based on work by Tom Wulf
 * This class creates a Person object with all the fields and methods.
 */
public class Person
{
    // Create all the instance fields
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;


    // Automates the ID generation
    private static int IDSeed = 1;
    public static int getIDSeed() {
        return IDSeed;
    }
    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }


    /**
     * Constructs a Person object.
     *
     * @param IDNum     the unique ID number
     * @param firstName the first name
     * @param lastName  the last name
     * @param title     the title (e.g., Mr., Dr., etc.)
     * @param YOB       the year of birth
     */
    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    /**
     * Overloads the constructor to use the default seed.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param title     the title (e.g., Mr., Dr., etc.)
     * @param YOB       the year of birth
     */
    public Person(String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    /**
     * Generates a new unique ID number using the current ID seed.
     *
     * @return a zero-padded 8-digit ID string
     */
    public String genIDNum()
    {
        String newID = "" + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }


    /** @return the ID number */
    public String getIDNum() {
        return IDNum;
    }


    /**
     * Sets the ID number.
     *
     * @param IDNum the new ID number
     */
    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }


    /** @return the first name */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /** @return the last name */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /** @return the title */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /** @return the year of birth */
    public int getYOB() {
        return YOB;
    }


    /**
     * Sets the year of birth.
     *
     * @param YOB the new year of birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }


    /**
     * Returns a string representation of the person.
     *
     * @return a formatted string including ID, title, full name, and year of birth
     */
    @Override
    public String toString()
    {
        return IDNum + ": " + title + " " + firstName + " " + lastName + " ("  + YOB + ")";
    }


    /** Returns a string representation of the person's full name. */
    public String fullName()
    {
        return firstName + " " + lastName;
    }


    /** Returns a string representation of the person's full name and title. */
    public String formalName()
    {
        return title + " " + fullName();
    }

    /** Uses YOB to calculate age for a specified year.
     * Uses the Calendar object to do these. Requires a bit of a web search.
     * @return the age in years
     * */
    public int getAge()
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return (year - YOB);
    }


    /** Returns a CSV String suitable to writing to a java text file. */
    public String toCSV()
    {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }


    /** Returns a JSON String suitable to writing to a java text file. */
    public String toJSON()
    {
        return "{" +
                "\"ID\":\"" + IDNum + "\","+
                "\"FirstName\":\"" + firstName + "\","+
                "\"LastName\":\"" + lastName + "\","+
                "\"Title\":\"" + title + "\","+
                "\"YOB\":" + YOB +
                "}";
    }


    /** Returns an XML String suitable to writing to a java text file. */
    public String toXML()
    {
        return "<Person>" +
                "<ID>" + IDNum + "</ID>" +
                "<FirstName>" + firstName + "</FirstName>" +
                "<LastName>" + lastName + "</LastName>" +
                "<Title>" + title + "</Title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    /**
     * Compares this person to another person for equality.
     *
     * @param o the other person to compare to
     * @return true if they are equal, false if not.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(IDNum, person.IDNum) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(title, person.title);
    }
}
