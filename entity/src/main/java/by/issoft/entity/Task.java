package by.issoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "task")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private Party party;

    @Column (name = "money")
    private Double money;

    @Column (name = "task_status")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

    @Column (name = "quantity")
    private Integer quantity;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", product=" + product +
                ", party=" + party.getId() +
                ", money=" + money +
                ", status=" + status +
                ", quantity=" + quantity +
                '}';
    }
}
