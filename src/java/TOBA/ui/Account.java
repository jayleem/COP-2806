package TOBA.ui;

/**
 *
 * @author Jason
 */
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private Double balance;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ArrayList<Transaction> transactions;

    public Account() {

    }

    public Account(User user, Double balance) {
        this.user = user;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getUser() {
        return user;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    //Method to display balance with correct format
    public String getFormattedBalance() {
        String sBalance = balance.toString();
        Double number = Double.parseDouble(sBalance);

        DecimalFormat format = new DecimalFormat("0.00");
        String formatted = format.format(number);

        return formatted;
    }

    public long getAcctID() {
        return accountId;
    }

    public void setAcctID(Long accountId) {
        this.accountId = accountId;
    }

    public void credit(Double value) {
        this.balance += value;
        this.transactions.add(new Transaction(value, "Credit"));
    }

    public void debit(Double value) {
        this.balance -= value;
        this.transactions.add(new Transaction(value, "Debit"));
    }

    public ArrayList<Transaction> getList() {
        return transactions;
    }
}
