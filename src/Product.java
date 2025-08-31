import java.util.Objects;


/**
 * @author Matt Bennett based on work by Tom Wulf
 * This class creates a Product object with all the fields and methods.
 */
public class Product
{
    // Create all the instance fields
    private String IDNum;
    private String Name;
    private String Description;
    private double Cost;

    // Automates the ID generation
    static private int IDSeed = 1;
    public static int getIDSeed() { return IDSeed; }
    public static void setIDSeed(int IDSeed) { Product.IDSeed = IDSeed; }


    /**
     * Constructs a Product object.
     * @param IDNum         the unique ID number
     * @param Name          the name of the product
     * @param Description   the description of the product
     * @param Cost          the cost of the product
     */
    public Product(String IDNum, String Name, String Description, double Cost)
    {
        this.IDNum = IDNum;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }


    /**
     * Overloads the constructor to use the default ID seed.
     * @param Name          the name of the product
     * @param Description   the description of the product
     * @param Cost          the cost of the product
     */
    public Product(String Name, String Description, double Cost)
    {
        this.IDNum = this.genIDNum();
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
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
    public String getIDNum()
    {
        return IDNum;
    }

    /**
     * Sets the ID number.
     *
     * @param IDNum the new ID number
     */
    public void setIDNum(String IDNum)
    {
        this.IDNum = IDNum;
    }


    /** @return the name */
    public String getName()
    {
        return Name;
    }

    /**
     * Sets the name.
     *
     * @param Name the new name
     */
    public void setName(String Name)
    {
        this.Name = Name;
    }


    /** @return the description */
    public String getDescription()
    {
        return Description;
    }


    /**
     * Sets the description.
     *
     * @param Description the new description
     */
    public void setDescription(String Description)
    {
        this.Description = Description;
    }


    /** @return the cost */
    public double getCost()
    {
        return (double) Cost;
    }


    /**
     * Sets the cost.
     *
     * @param Cost the new cost
     */
    public void setCost(double Cost)
    {
        this.Cost = Cost;
    }


    /**
     * Returns a string representation of the product.
     *
     * @return a formatted string including ID, name, description, and cost
     */
    @Override
    public String toString()
    {
        return IDNum + ": " + Name + "-- " + Description + " (" + Cost + ")";
    }


    /**
     * Compares this product to another product for equality.
     *
     * @param o the other product to compare to
     * @return true if they are equal, false if not.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Cost == product.Cost &&
                Objects.equals(IDNum, product.IDNum) &&
                Objects.equals(Name, product.Name) &&
                Objects.equals(Description, product.Description);
    }


    /** Returns a CSV String suitable to writing to a java text file. */
    public String toCSV()
    {
        return IDNum + "," + Name + "," + Description + "," + Cost;
    }


    /** Returns a JSON String suitable to writing to a java text file. */
    public String toJSON()
    {
        return "{" +
                "\"IDNum\":\"" + IDNum + "\"," +
                "\"Name\":\"" + Name + "\"," +
                "\"Description\":\"" + Description + "\"," +
                "\"Cost\":" + Cost +
                "}";
    }

    /** Returns an XML String suitable to writing to a java text file. */
    public String toXML()
    {
        return "<Product>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<Name>" + Name + "</Name>" +
                "<Description>" + Description + "</Description>" +
                "<Cost>" + Cost + "</Cost>" +
                "</Product>";
    }
}
