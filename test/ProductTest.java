import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    /** create the class variables for the 3 instances */
    Product p1, p2, p3;

    /** create the 3 instances of the class before each test */
    @BeforeEach
    void setUp()
    {
        Product.setIDSeed(1);
        p1 = new Product("Eggs", "Two Scrambled Fried or Boiled", 5.59);
        p2 = new Product("Bacon", "Four Strips Sugar Cured and Fried", 4.59);
        p3 = new Product("Home Fries", "Diced Potatoes with Onions and Peppers", 4.99);
    }

    /** tests the seed generator after 3 calls, should be 4 */
    @Test
    void getIDSeed() {
        assertEquals(4, Product.getIDSeed());
    }

    /** Test the constructor with p1 */
    @Test
    void getIDNum() {
        assertEquals("00000001", p1.getIDNum());
    }

    /** Test the setName method */
    @Test
    void setName()
    {
        p2.setName("Brains");
        assertEquals("Brains", p2.getName());
    }

    /** Test the setDescription method */
    @Test
    void setDescription()
    {
        p2.setDescription("Freshly Earned");
        assertEquals("Freshly Earned", p2.getDescription());
    }

    /** Test the setCost method */
    @Test
    void setCost()
    {
        p2.setCost(10.99);
        assertEquals(10.99, p2.getCost());
    }

    /** Test the toString method */
    @Test
    void testToString()
    {
        assertEquals("00000001: Eggs-- Two Scrambled Fried or Boiled (5.59)", p1.toString());
    }

    /** Test the toCSV method */
    @Test
    void toCSV()
    {
        assertEquals("00000001,Eggs,Two Scrambled Fried or Boiled,5.59", p1.toCSV());
    }

    /** Test the toJSON method */
    @Test
    void toJSON()
    {
        assertEquals("{\"IDNum\":\"00000001\",\"Name\":\"Eggs\",\"Description\":\"Two Scrambled Fried or Boiled\",\"Cost\":5.59}", p1.toJSON());
    }

    /** Test the toXML method */
    @Test
    void toXML()
    {
        assertEquals("<Product><IDNum>00000001</IDNum><Name>Eggs</Name><Description>Two Scrambled Fried or Boiled</Description><Cost>5.59</Cost></Product>", p1.toXML());
    }


    /** Test the Equals method */
    @Test
    void testEquals()
    {
        p1.setIDNum("00000002");
        p1.setName("Bacon");
        p1.setDescription("Four Strips Sugar Cured and Fried");
        p1.setCost(4.59);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        assertEquals(true, p1.equals(p2));
    }
}