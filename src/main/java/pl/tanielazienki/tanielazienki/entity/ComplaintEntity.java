package pl.tanielazienki.tanielazienki.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "complaint")
public class ComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productCode;
    private LocalDate dataOfReport;
    private LocalDate dataOfReportAnswer;
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderEntity providerEntity;
    private LocalDate dateOfPurchase;
    //client info
    private String username;
    private String surname;
    private String phoneNumber;
    private String clientAddress;
    private String post;
    private String zipCode;
}
