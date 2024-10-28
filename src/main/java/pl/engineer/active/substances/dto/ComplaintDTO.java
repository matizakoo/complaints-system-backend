package pl.tanielazienki.tanielazienki.dto;

import lombok.*;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;
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
@ToString
public class ComplaintDTO {
    private Integer id;
    private String productCode;
    private LocalDate dataOfReport;
    private LocalDate dataOfReportAnswer;
    private ProviderEntity providerEntity;
    private CategoryEntity categoryEntity;
    private ContractorEntity contractorEntity;
    private LocalDate dateOfPurchase;
    private String factureId;
    private String username;
    private String surname;
    private String phoneNumber;
    private String email;
    private String status;
    private List<NoteEntity> notes = new ArrayList<>();
}
