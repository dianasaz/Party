package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table (name = "task")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    //todo not blank or not
    @Column (name = "money")
    private Double money;

    @Column (name = "task_status")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", money=" + money +
                ", status=" + status +
                '}';
    }
}
