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
        assertEquals(227, invoiceGenerator.calculate_fare(5, 172));
    }
}