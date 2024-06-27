package pl.tanielazienki.tanielazienki.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
    private Integer id;
    private String productCode;
    private LocalDate dataOfReport;
    private LocalDate dataOfReportAnswer;
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
