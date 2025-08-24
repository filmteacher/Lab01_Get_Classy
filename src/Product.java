public class Product
{
    // create all the instance fields first, these are private to encapsulate the data
    private String IDNum;
    private String Name;
    private String Description;
    private double Cost;

    //to automate the ID generation, followed by the getter and setter methods
    static private int IDSeed = 1;

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    // second create a constructor, this is public
    public Product(String IDNum, String Name, String Description, double Cost)
    {
        this.IDNum = IDNum;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }

    // overload the constructor to use the default seed
    public Product(String Name, String Description, double Cost)
    {
        this.IDNum = this.genIDNum();
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getCost() {
        return (float) Cost;
    }

    public void setCost(float Cost) {
        this.Cost = Cost;
    }

    // create a toString method
    @Override
    public String toString()
    {
        return "Product [IDNum=" + IDNum + ", Name=" + Name + ", Description=" + Description + ", Cost=" + Cost + "]";
    }

    // create an equals override
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // returns a CSV String suitable to writing to a java text file.
    public String toCSV()
    {
        return IDNum + "," + Name + "," + Description + "," + Cost;
    }

    // returns a JSON String suitable to writing to a java text file.
    public String toJSON()
    {
        return "{\n" +
                "  \"IDNum\": \"" + IDNum + "\",\n" +
                "  \"Name\": \"" + Name + "\",\n" +
                "  \"Description\": \"" + Description + "\",\n" +
                "  \"Cost\": " + Cost + "\n" +
                "}";
    }

    // returns an XML String suitable to writing to a java text file.
    public String toXML()
    {
        return "<Product>\n" +
                "  <IDNum>" + IDNum + "</IDNum>\n" +
                "  <Name>" + Name + "</Name>\n" +
                "  <Description>" + Description + "</Description>\n" +
                "  <Cost>" + Cost + "</Cost>\n" +
                "</Product>";
    }
}
