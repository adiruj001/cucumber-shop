package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) throws NotEnoughQuantityException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @When("I buy {string} with over quantity {int}")
    public void i_buy_with_over_quantity(String name, int quantity) throws NotEnoughQuantityException {
        Product prod = catalog.getProduct(name);
        assertThrows(NotEnoughQuantityException.class, () -> order.addItem(prod, quantity));
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

}

