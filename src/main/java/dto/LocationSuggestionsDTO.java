package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationSuggestionsDTO {

    private int id;

    private String name;

    private int country_id;

    private String country_name;

    private String country_flag_url;

    private int should_experiment_with;

    private int has_go_out_tab;

    private int discovery_enabled;

    private int has_new_ad_format;

    private int is_state;

    private int state_id;

    private String state_name;

    private String state_code;
}
