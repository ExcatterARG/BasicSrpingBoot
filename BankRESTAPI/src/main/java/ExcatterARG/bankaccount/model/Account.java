package ExcatterARG.bankaccount.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Column(name="balance", nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    Set<Operation> operations;

    public Account(CurrencyType currency, BigDecimal balance){
        this.currency = currency;
        this.balance = balance;
    }

    public Account(){}

    public CurrencyType getCurrency(){
        return this.currency;
    }

    public void setCurrency(CurrencyType currency){
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<Operation> getOperations(){
        return this.operations;
    }
}


