package ExcatterARG.bankaccount.service;

import ExcatterARG.bankaccount.dto.AccountDTO;
import ExcatterARG.bankaccount.dto.OperationDTO;
import java.util.List;

public interface AccountService {

    AccountDTO CreateAccount(AccountDTO accountDTO);
    void DeleteAccount(Long accountId);
    List<AccountDTO> ListAllAccounts();
    void GenerateOperation(OperationDTO operationDTO);
    List<OperationDTO> ListAllOperations(Long accountId);
}
