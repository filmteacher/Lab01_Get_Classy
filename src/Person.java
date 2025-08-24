import java.util.Calendar;

public class Person
{
    // create all the instance fields first, these are private to encapsulate the data
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    //to automate the ID generation, followed by the getter and setter methods
    private static int IDSeed = 1;

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    // second create a constructor, this is public
    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    // overload the constructor to use the default seed
    public Person(String firstName, String lastName, int YOB)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    // a method to generate a new ID
    public String genIDNum()
    {
        String newID = "" + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }

        IDSeed++;

        return newID;
    }

    // third create getters and setters, also public
    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    // create a toString method
    @Override
    public String toString()
    {
        return "Person [IDNum=" + IDNum + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", YOB=" + YOB + "]";
    }

    // create an equals override
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // returns firstName, space, lastName
    public String fullName()
    {
        return firstName + " " + lastName;
    }

    // returns title, space, fullName
    public String formalName()
    {
        return title + " " + fullName();
    }

    // uses YOB to calculate age for a specified year
    // use the Calendar object to do these. Requires a bit of a web search.
    public int getAge()
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return (year - YOB);
    }

    // returns a CSV String suitable to writing to a java text file.
    public String toCSV()
    {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    // returns a JSON String suitable to writing to a java text file.
    public String toJSON()
    {
        return "{\n" +
                "  \"IDNum\": \"" + IDNum + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    // returns an XML String suitable to writing to a java text file.
    public String toXML()
    {
        return "<Person>\n" +
                "  <IDNum>" + IDNum + "</IDNum>\n" +
                "  <firstName>" + firstName + "</firstName>\n" +
                "  <lastName>" + lastName + "</lastName>\n" +
                "  <title>" + title + "</title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }
}
