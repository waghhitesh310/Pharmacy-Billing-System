package model;

import java.util.Date;
import java.util.List;

public class Bill {
    private int billId;
    private int customerId;
    private Date billDate;
    private List<BillItem> billItems; // List to hold items in the bill

    public Bill(int billId, int customerId, Date billDate, List<BillItem> billItems) {
        this.billId = billId;
        this.customerId = customerId;
        this.billDate = billDate;
        this.billItems = billItems;
    }

    // Getters and setters
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }

    public List<BillItem> getBillItems() { return billItems; }
    public void setBillItems(List<BillItem> billItems) { this.billItems = billItems; }
}
