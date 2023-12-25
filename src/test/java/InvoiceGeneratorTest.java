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
        assertEquals(227, invoiceGenerator.calculate_fare(5, 20, RideType.NORMAL));
    }


    /* UC-2 aggregate fare of multiple rides
     * Refactored UC-3 to return invoice*/
    @Test
    void givenRideCount_shouldReturnInvoiceSummary(){
        Ride[] rides = {
                new Ride(4, 10, RideType.NORMAL),
                new Ride(8, 15, RideType.PREMIUM)
        };
        InvoiceSummary summary = invoiceGenerator.calculate_fare(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 227.0);
        assertEquals(expectedInvoice, summary);
    }

    /* UC-4 invoice-service */
    @Test
    void givenUserId_returnsInvoiceSummary(){
        String user_id = "anushka";
        Ride[] rides = {
                new Ride(4, 10, RideType.NORMAL),
                new Ride(8, 15, RideType.PREMIUM)
        };
        invoiceGenerator.addRides(user_id, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(user_id);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 227.0);
        assertEquals(expectedInvoice, summary);
    }

    /* UC-5 Premium rides */
    @Test
    void givenRideTypes_returnInvoiceSummary(){
        Ride[] rides = {
                new Ride(4, 10, RideType.NORMAL),
                new Ride(8, 15, RideType.PREMIUM)
        };

        invoiceGenerator.addRides("001", rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary("001");
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 227.0);
    }
}