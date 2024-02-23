namespace Stand.Models
{
    public class Transaction
    {
        long TransactionId {  get; }

        string TransactionDate { get; set; }

        double SellingPrice { get; set; }

        long BuyerId { get; }

        long VehicleId { get; }


    }
}
