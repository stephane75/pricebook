import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

/**
 * User: stephane
 * Date: 17/02/14
 */
public class UserTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("bob@gmail.com", "Bob", "secret").save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", "bob@gmail.com").first();

        // Test
        assertNotNull(bob);
        assertNotNull(bob.creationDate);
        assertEquals("secret", bob.password);
        assertEquals("Bob", bob.login);
        assertEquals("bob@gmail.com", bob.email);
    }

    @Test
    public void tryFindByEmail(){
        new User("bob@gmail.com", "Bob", "secret").save();
        User bob = User.findByEmail("bob@gmail.com");
        assertNotNull(bob);
    }

    @Test
    public void tryCreateUserWithSameEmail() {
        // Create a new user and save it
        new User("bob@gmail.com", "Bob", "secret").save();
        User u = null;
        try{
            u = new User("bob@gmail.com", "Bob2", "secret2").save();
        }catch(Exception e){
            assertNull(u);
        }
    }

    @Test
    public void fullTest() {
        Fixtures.loadModels("data.yml");

        // Count things
        assertEquals(2, User.count());
    }
}
