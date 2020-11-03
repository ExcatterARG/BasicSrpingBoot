package ExcatterARG.bankaccount.dto;

import ExcatterARG.bankaccount.model.OperationType;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OperationDTO {

    private OperationType opType;
    private String description;
    private BigDecimal value;
    private Long accountId;
    private Timestamp createdAt;

    public OperationDTO(OperationType operation, String description, BigDecimal value, Long accountId) {
        this.opType = operation;
        this.description = description;
        this.value = value;
        this.accountId = accountId;
    }

    public OperationType getOpType() {
        return opType;
    }

    public void setOpType(OperationType opType) {
        this.opType = opType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
