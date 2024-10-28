package pl.tanielazienki.tanielazienki.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractorDTO {
    private Integer id;
    private String contractorName;
}
