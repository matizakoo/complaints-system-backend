package pl.tanielazienki.tanielazienki.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contractor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contractorName;
}
