package pl.engineer.active.substances.dto;

import lombok.*;
import pl.engineer.active.substances.entity.CategoryEntity;
import pl.engineer.active.substances.entity.ContractorEntity;
import pl.engineer.active.substances.entity.NoteEntity;
import pl.engineer.active.substances.entity.ProviderEntity;

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
