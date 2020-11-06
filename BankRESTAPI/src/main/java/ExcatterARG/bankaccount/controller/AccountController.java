package ExcatterARG.bankaccount.controller;

import ExcatterARG.bankaccount.dto.AccountDTO;
import ExcatterARG.bankaccount.dto.OperationDTO;
import ExcatterARG.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/account")
    @ResponseBody
    public AccountDTO CreateAccount(@RequestBody AccountDTO accountDTO){
        return this.accountService.CreateAccount(accountDTO);
    }

    @GetMapping(path = "/account")
    @ResponseBody
    public List<AccountDTO> GetAccounts(){
        return this.accountService.ListAllAccounts();
    }


    @DeleteMapping(path = "/account/{id}")
    public void DeleteAccount(@PathVariable("id") Long accountId){
        this.accountService.DeleteAccount(accountId);
    }

    @PostMapping(path = "/account/{id}/operation")
    public void GenerateOperation(@PathVariable("id") Long accountID, @RequestBody OperationDTO operationDTO){
        operationDTO.setAccountId(accountID);
        this.accountService.GenerateOperation(operationDTO);
    }

    @GetMapping(path="/account/{id}/operation")
    public List<OperationDTO> GetAllOperations(@PathVariable("id") Long accountId){
        return this.accountService.ListAllOperations(accountId);
    }
}
