package pl.engineer.active.substances.dto;

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
