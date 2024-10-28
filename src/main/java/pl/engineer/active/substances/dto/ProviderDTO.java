package pl.tanielazienki.tanielazienki.dto;

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
