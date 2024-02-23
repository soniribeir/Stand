using System.Configuration;

namespace Stand.Models
{
    public class Buyer
    {
        long BuyerId { get; }

        string BuyerName { get; set; }

        string BuyerAddress {  get; set; }

        string BuyerPhoneNumber {  get; set; }

        int BuyerNif {  get; set; }

        string BuyerEmailAddress {  get; set; }
    }
}
