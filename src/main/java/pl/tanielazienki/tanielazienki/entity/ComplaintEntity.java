package pl.tanielazienki.tanielazienki.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryEntity;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "contractor_id", nullable = false)
    private ContractorEntity contractorEntity;

    private LocalDate dateOfPurchase;
    private String factureId;

    //client info
    private String username;
    private String surname;
    private String phoneNumber;
    private String email;
    private String status;

    @OneToMany(mappedBy = "complaintEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("dateTime DESC")
    private List<NoteEntity> notes = new ArrayList<>();
}
