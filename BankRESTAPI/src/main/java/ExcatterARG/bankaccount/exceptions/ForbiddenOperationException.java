package ExcatterARG.bankaccount.exceptions;

import java.math.BigDecimal;

public class ForbiddenOperationException extends RuntimeException {
    Long accountId;
    BigDecimal balance;
    String reason;

    public ForbiddenOperationException(Long accountId, BigDecimal balance, String reason){
        this.accountId = accountId;
        this.balance = balance;
        this.reason = reason;
    }

    public Long getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getReason() {
        return reason;
    }
}
