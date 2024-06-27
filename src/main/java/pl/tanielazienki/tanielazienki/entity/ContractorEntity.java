package pl.tanielazienki.tanielazienki.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.inject.spi.Interceptor;

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
