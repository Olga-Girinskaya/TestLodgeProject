package models;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseBuilder {
    public String title;
    public String titleUpdate;
}
