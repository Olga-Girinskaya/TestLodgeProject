package models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBuilder {

    private String email;
    private String psw;
}
