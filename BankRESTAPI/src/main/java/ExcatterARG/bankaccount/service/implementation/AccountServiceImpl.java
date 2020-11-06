package ExcatterARG.bankaccount.service.implementation;

import ExcatterARG.bankaccount.dto.AccountDTO;
import ExcatterARG.bankaccount.dto.OperationDTO;
import ExcatterARG.bankaccount.exceptions.AccountNotFoundException;
import ExcatterARG.bankaccount.exceptions.ForbiddenOperationException;
import ExcatterARG.bankaccount.model.Account;
import ExcatterARG.bankaccount.model.CurrencyType;
import ExcatterARG.bankaccount.model.Operation;
import ExcatterARG.bankaccount.model.OperationType;
import ExcatterARG.bankaccount.repository.AccountRepository;
import ExcatterARG.bankaccount.repository.OperationRepository;
import ExcatterARG.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationRepository operationRepository;

    public AccountDTO CreateAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setCurrency(accountDTO.getCurrency());
        account.setBalance(accountDTO.getBalance());
        this.accountRepository.save(account);
        accountDTO.setAccountNumber(account.getId());
        return accountDTO;
    }

    public void DeleteAccount(Long accountId){
        Optional<Account> result = this.accountRepository.findById(accountId);
        if(!result.isPresent()){
            throw new AccountNotFoundException(accountId);
        }
        Account account = result.get();
        if(!account.getOperations().isEmpty()){
            throw new ForbiddenOperationException(account.getId(), account.getBalance(),
                    "Operation not allow due to operations related to account");
        }
        this.accountRepository.deleteById(accountId);
    }

    public List<AccountDTO> ListAllAccounts(){
        List <Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (Account account: accounts){
            AccountDTO accountDTO = new AccountDTO(account.getCurrency(), account.getBalance());
            accountDTO.setAccountNumber(account.getId());
            accountDTOS.add(accountDTO);
        }
        return accountDTOS;
    }

    public void GenerateOperation(OperationDTO operationDTO){

        Optional<Account> account = accountRepository.findById(operationDTO.getAccountId());
        if (!account.isPresent()){
            throw new AccountNotFoundException(operationDTO.getAccountId());
        }
        Account foundAccount = account.get();
        if(operationDTO.getOpType() == OperationType.DEBIT){
            if(!isOperationValid(foundAccount.getBalance(), operationDTO.getValue(), foundAccount.getCurrency())){
                throw new ForbiddenOperationException(operationDTO.getAccountId(), foundAccount.getBalance(),
                        "Operation not allowed due to lack of credit");
            }
        }
        Operation operation = new Operation();
        operation.setOpType(operationDTO.getOpType());
        operation.setAccount(foundAccount);
        operation.setCreateAt(Timestamp.from(Instant.now()));
        operation.setValue(operationDTO.getValue());
        operation.setDescription(operationDTO.getDescription());
        operationRepository.save(operation);

        if(operationDTO.getOpType() == OperationType.CREDIT){
            foundAccount.setBalance(foundAccount.getBalance().add(operationDTO.getValue()));
        }
        else{
            foundAccount.setBalance(foundAccount.getBalance().subtract(operationDTO.getValue()));
        }
        accountRepository.save(foundAccount);
    }

    public List<OperationDTO> ListAllOperations(Long accountId){
        Optional<Account> queryResult = this.accountRepository.findById(accountId);
        if(!queryResult.isPresent()){
            throw new AccountNotFoundException(accountId);
        }
        Set<Operation> operations = queryResult.get().getOperations();
        List<OperationDTO> operationsDTO = new ArrayList<>();
        for(Operation operation: operations){
            OperationDTO o = new OperationDTO(operation.getOpType(), operation.getDescription(), operation.getValue(), accountId);
            o.setCreatedAt(operation.getCreateAt());
            operationsDTO.add(o);
        }
        operationsDTO.sort((op1, op2) -> op2.getCreatedAt().compareTo(op1.getCreatedAt()));
        return operationsDTO;
    }

    private boolean isOperationValid(BigDecimal accountBalance, BigDecimal operationValue, CurrencyType currencyType){
        BigDecimal operationResult = accountBalance.subtract(operationValue);
        BigDecimal threshold;
        switch (currencyType){
            case PESO:
                threshold = BigDecimal.valueOf(-100);
                break;
            case DOLAR:
                threshold = BigDecimal.valueOf(-150);
                break;
            case EURO:
                threshold = BigDecimal.valueOf(-200);
                break;
            default:
                return false;
        }
        if(operationResult.compareTo(threshold) == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
