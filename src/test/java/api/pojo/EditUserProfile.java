package api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EditUserProfile {
    private String bio;
    private String email;
    private String full_name;
    private String instagram;
    private String location;
    private String twitter;
    private String username;
    private String website;
}
