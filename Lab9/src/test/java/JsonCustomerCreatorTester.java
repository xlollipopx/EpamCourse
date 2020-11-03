import com.epam.task.nine.data.JsonCustomerCreator;
import com.epam.task.nine.model.Customer;
import com.epam.task.nine.model.OrderType;
import com.epam.task.nine.model.Restaurant;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

public class JsonCustomerCreatorTester {
    private static final String INPUT_STRING = "{  \"customers\": [    {      \"name\": \"Tom\",   " +
            "   \"order\": [        \"BURGER\",        \"TEA\"      ]    },    {      \"name\": \"Dom\",    " +
            "  \"order\": [        \"COFFEE\",        \"TEA\"      ]    }  ]}";

    private static final Restaurant restaurant = Mockito.mock(Restaurant.class);
    private static final List<Customer> EXPECTED = Arrays.asList(
            new Customer("Tom", Arrays.asList(OrderType.BURGER, OrderType.TEA)),
            new Customer("Dom", Arrays.asList(OrderType.COFFEE, OrderType.TEA))
    );
    private final JsonCustomerCreator customersCreator = new JsonCustomerCreator();

    @Test
    public void testCreateShipsShouldReturnShipsListWhenGetData() {
        //when

        List<Customer> actual = customersCreator.createCustomers(INPUT_STRING);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
