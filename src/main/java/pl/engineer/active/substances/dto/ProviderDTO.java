package pl.engineer.active.substances.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {
    private Integer id;
    private String nameOfProvider;
}
