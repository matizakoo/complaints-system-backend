package pl.tanielazienki.tanielazienki.dto;

import jakarta.persistence.*;
import lombok.*;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private ContractorEntity contractorEntity;
    private LocalDate dateOfPurchase;
    private String factureId;
    private String username;
    private String surname;
    private String phoneNumber;
    private String email;
    private List<NoteEntity> notes = new ArrayList<>();
}
