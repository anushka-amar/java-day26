public class Main {
    public static void main(String[] args) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides1 = {
                new Ride(4, 10),
                new Ride(8, 15),
                new Ride(12, 20)
        };

        invoiceGenerator.addRides("001", rides1);
        invoiceGenerator.getInvoiceSummary("001");
    }

}