package by.iba.party.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column (name = "kol")
    private Integer kol;

    @Override
    public String toString() {
        return "Task{" +
                ", user=" + user +
                ", product=" + product +
                ", party=" + party +
                ", money=" + money +
                ", status=" + status +
                ", kol=" + kol +
                '}';
    }
}
