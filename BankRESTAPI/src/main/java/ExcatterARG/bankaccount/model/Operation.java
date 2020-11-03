package ExcatterARG.bankaccount.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="operation_type")
    @Enumerated(EnumType.STRING)
    private OperationType opType;

    @Column(name="created_at")
    private Timestamp createAt;

    @Column(name="description")
    private String description;

    @Column(name="value")
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name="account_id", nullable = false)
    private Account account;

    public Operation(OperationType type, Timestamp createAt, String description, BigDecimal value, Account account) {
        this.opType = type;
        this.createAt = createAt;
        this.description = description;
        this.value = value;
        this.account = account;
    }

    public Operation(){}

    public Long getId() {
        return id;
    }

    public OperationType getOpType() {
        return opType;
    }

    public void setOpType(OperationType opType) {
        this.opType = opType;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
