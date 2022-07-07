package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.TestCaseBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void createProjectTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .project("diploma")
                .build();

        Assert.assertEquals(dashboardStep.createProjectStep(testCaseBuilder.getProject()).getSuccessText().getText(),
                "Successfully added the new project.");
    }
}
