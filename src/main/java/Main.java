public class Main {
    public static void main(String[] args) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(4, 10),
                new Ride(8, 15),
                new Ride(12, 20)
        };
        System.out.println("Total number of rides: "+rides.length);
        System.out.println("Total fare is: "+ invoiceGenerator.aggregate_fare(rides));
        System.out.println("Average fare per ride is: "+ invoiceGenerator.average_fare(rides));
    }

}
