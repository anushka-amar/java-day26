public class InvoiceSummary {
    private int ride_count;
    private double total_fare;
    private double avg_fare;

    public InvoiceSummary(int ride_count, double total_fare) {
        this.ride_count = ride_count;
        this.total_fare = total_fare;
        this.avg_fare = this.total_fare/this.ride_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return ride_count == summary.ride_count && Double.compare(total_fare, summary.total_fare) == 0 && Double.compare(avg_fare, summary.avg_fare) == 0;
    }

    public void print_summary(){
        System.out.println("Total rides taken: "+ this.ride_count);
        System.out.println("Total fare applicable: "+ this.total_fare);
        System.out.println("Average fare per ride: "+this.avg_fare);
        System.out.println("----------------------------------------");
    }
}
