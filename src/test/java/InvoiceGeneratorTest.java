import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator;

    @BeforeEach //re-initializing the object before every test case runs
    void init(){
        invoiceGenerator = new InvoiceGenerator();
    }

    /* UC-1 calculate fare */
    @Test
    void givenDistanceAndTime_shouldReturnTotalFare(){
        assertEquals(227, invoiceGenerator.calculate_fare(5, 20));
    }


    /* UC-2 aggregate fare of multiple rides
     * Refactored UC-3 to return invoice*/
    @Test
    void givenRideCount_shouldReturnInvoiceSummary(){
        Ride[] rides = {
                new Ride(4, 10),
                new Ride(8, 15)
        };
        InvoiceSummary summary = invoiceGenerator.calculate_fare(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 155.0);
        assertEquals(expectedInvoice, summary);
    }

    /* UC-4 invoice-service */
    @Test
    void givenUserId_returnsInvoiceSummary(){
        String user_id = "anushka";
        Ride[] rides = {
                new Ride(4, 10),
                new Ride(8, 15)
        };
        invoiceGenerator.addRides(user_id, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(user_id);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 155.0);
        assertEquals(expectedInvoice, summary);
    }
}