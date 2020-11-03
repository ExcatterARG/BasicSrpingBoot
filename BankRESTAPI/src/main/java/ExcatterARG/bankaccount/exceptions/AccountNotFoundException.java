package ExcatterARG.bankaccount.exceptions;


public class AccountNotFoundException extends RuntimeException {

    Long accountId;
    public AccountNotFoundException(Long accountId){
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
