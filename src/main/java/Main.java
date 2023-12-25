public class Main {
    public static void main(String[] args) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides1 = {
                new Ride(4, 10, RideType.NORMAL),
                new Ride(8, 15, RideType.PREMIUM),
                new Ride(12, 20, RideType.NORMAL)
        };
        invoiceGenerator.addRides("001", rides1);
        InvoiceSummary summary1 = invoiceGenerator.getInvoiceSummary("001");
        System.out.println("Invoice Summary for User 001: " );
        summary1.print_summary();

        Ride[] rides2 = {
                new Ride(6, 12, RideType.PREMIUM),
                new Ride(10, 18, RideType.NORMAL),
                new Ride(15, 25, RideType.PREMIUM)
        };
        invoiceGenerator.addRides("002", rides2);
        InvoiceSummary summary2 = invoiceGenerator.getInvoiceSummary("002");
        System.out.println("Invoice Summary for User 002: ");
        summary2.print_summary();
    }
}