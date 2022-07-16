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
    public String step;
    public String expectedResult;
    public String project;
    public String steps;
}
