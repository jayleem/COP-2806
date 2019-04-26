package TOBA.ui;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transId;
    private Double transAmt;
    private String transType;

    public Transaction() {
    }

    public Transaction(Double value, String type) {
        this.transAmt = value;
        this.transType = type;
    }

    public Double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(Double value) {
        this.transAmt = transAmt;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String type) {
        this.transType = transType;
    }

    //Method to display balance with correct format
    public String getFormattedBalance() {
        String sBalance = transAmt.toString();
        Double number = Double.parseDouble(sBalance);

        DecimalFormat format = new DecimalFormat("0.00");
        String formatted = format.format(number);

        return formatted;
    }
}
