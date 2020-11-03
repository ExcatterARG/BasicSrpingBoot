package ExcatterARG.bankaccount.dto;

import ExcatterARG.bankaccount.model.CurrencyType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountDTO {


    private Long accountNumber;
    private CurrencyType currency;
    private BigDecimal balance;

    public AccountDTO(CurrencyType currency, BigDecimal balance) {
        this.currency = currency;
        this.balance = balance;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
