import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{
    /** create the class variables for the 6 instances */
    Person p1, p2, p3, p4, p5, p6;

    /** create the 6 instances of the class before each test */
    @BeforeEach
    void setUp()
    {
        Person.setIDSeed(1);
        p1 = new Person("Cheri", "O'Teri", "Mrs.", 1955);
        p2 = new Person("Dan", "Akroyd", "Mr.", 1975);
        p3 = new Person("Gilda", "Radner", "Mrs.", 1960);
        p4 = new Person("John", "Belushi", "Mr.", 1965);
        p5 = new Person("Chevy", "Chase", "Mr.", 1970);
        p6 = new Person("Jane", "Curtain", "Mrs.", 1975);
    }

    /** tests the seed generator after 6 calls, should be 7 */
    @Test
    void getIDSeed() {
        assertEquals(7, Person.getIDSeed());
    }

    /** Test the constructor with p1 */
    @Test
    void getIDNum() {
        assertEquals("00000001", p1.getIDNum());
    }

    /** Test the setFirstName method */
    @Test
    void setFirstName()
    {
        p1.setFirstName("Bobby");
        assertEquals("Bobby", p1.getFirstName());
    }

    /** Test the setLastName method */
    @Test
    void setLastName()
    {
        p1.setLastName("Tester");
        assertEquals("Tester", p1.getLastName());
    }

    /** Test the setYOB method */
    @Test
    void setTitle()
    {
        p1.setTitle("Mr.");
        assertEquals("Mr.", p1.getTitle());
    }

    /** Test the setYOB method */
    @Test
    void setYOB()
    {
        p1.setYOB(1950);
        assertEquals(1950, p1.getYOB());
    }

    /** Test the ToString method */
    @Test
    void testToString()
    {
        assertEquals("00000001: Mrs. Cheri O'Teri (1955)", p1.toString());
    }

    /** Test the Equals method */
    @Test
    void testEquals()
    {
        p1.setIDNum("00000002");
        p1.setFirstName("Dan");
        p1.setLastName("Akroyd");
        p1.setTitle("Mr.");
        p1.setYOB(1975);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        assertEquals(true, p1.equals(p2));
    }

    /** Test the fullName method */
    @Test
    void fullName()
    {
        assertEquals("Cheri O'Teri", p1.fullName());
    }

    /** Test the formalName method */
    @Test
    void formalName()
    {
        assertEquals("Mrs. Cheri O'Teri", p1.formalName());
    }

    /** Test the getAge method */
    @Test
    void getAge()
    {
        assertEquals(70, p1.getAge());
    }

    /** Test the toCSV method */
    @Test
    void toCSV()
    {
        assertEquals("00000001,Cheri,O'Teri,Mrs.,1955", p1.toCSV());
    }

    /** Test the toJSON method */
    @Test
    void toJSON()
    {
        assertEquals("{\"ID\":\"00000001\",\"FirstName\":\"Cheri\",\"LastName\":\"O'Teri\",\"Title\":\"Mrs.\",\"YOB\":1955}", p1.toJSON());
    }


    @Test
    void toXML()
    {
        assertEquals("<Person><ID>00000001</ID><FirstName>Cheri</FirstName><LastName>O'Teri</LastName><Title>Mrs.</Title><YOB>1955</YOB></Person>", p1.toXML());
    }
}