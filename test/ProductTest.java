import models.*;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import java.util.List;

/**
 * User: stephane
 * Date: 17/02/14
 */
public class ProductTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createProduct() {
        // Create a new product
        new Product("Nutella", "Chocolat à tartiner", "/nutella.png").save();

        // Test that the product has been created
        assertEquals(1, Product.count());
    }

    @Test
    public void addPrices() {
        // Create a new user
        User user = new User("bob@gmai.com", "Bob", "secret").save();

        // Create a new Store
        Store store = new Store("Leclerc", "/logo.png", "levallois").save();

        // Create a new product
        Product product = new Product("Nutella", "Chocolat à tartiner", "/nutella.png").save();

        product.addPrice(12.0f, user, store);

        // Test that the product has been created
        assertEquals(1, Product.count());
        assertEquals(1, Price.count());
        assertEquals(1, Store.count());
        assertEquals(1, User.count());
    }

    @Test
    public void categorize(){
        Fixtures.loadModels("data.yml");

        // Count things
        assertEquals(4, Category.count());
        assertEquals(4, Product.count());

        Category category = Category.findOrCreateByName("legume");
        List<Product> products = Product.findProductByCategory("legume");
        assertEquals(1, products.size());
        assertEquals(category, products.get(0).categories.iterator().next());

        assertEquals(2, Product.findProductByCategory("fruit").size());
    }

    @Test
    public void deleteProduct(){
        Fixtures.loadModels("data.yml");

        // Count things
        assertEquals(4, Category.count());
        assertEquals(4, Product.count());
        assertEquals(2, Price.count());

        List<Product> products = Product.findProductByName("nutella");
        assertEquals(2, products.get(0).prices.size());

        products.get(0).delete();
        assertEquals(3, Product.count());
        assertEquals(0, Price.count());
    }
}
