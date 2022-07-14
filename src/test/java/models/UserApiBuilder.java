package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserApiBuilder {

    private int id;
    private String name;
    private String email;
    @SerializedName(value = "is_active")
    private boolean active;
    @SerializedName(value = "role_id")
    private int roleId;
    @SerializedName(value = "is_admin")
    private boolean admin;
    @SerializedName(value = "email_notifications")
    private boolean emailNotifications;
    @SerializedName(value = "mfa_required")
    private int mfaRequired;
    private String role;
    @SerializedName(value = "group_ids")
    private List<UserApiBuilder> groupIds;
    private String error;
}
