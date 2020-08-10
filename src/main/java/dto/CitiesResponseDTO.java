package dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitiesResponseDTO {

    private List<LocationSuggestionsDTO> location_suggestions;

    private String status;

    private int has_more;

    private int has_total;

    private boolean user_has_addresses;
}
