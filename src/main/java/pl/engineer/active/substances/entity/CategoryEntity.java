package pl.engineer.active.substances.entity;

import jakarta.persistence.*;
import lombok.*;

@jakarta.persistence.Entity
@Getter
@Setter
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryEntity {
    public CategoryEntity(String category) {
        this.category = category;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category")
    private String category;
}
