package com.rey.aplikasikeuangan3;

public class Transaction {
    private String type;
    private String amount;
    private String date;

    // Konstructor
    public Transaction(String type, String amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
