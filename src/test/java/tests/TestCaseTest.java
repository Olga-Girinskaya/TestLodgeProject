package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.TestCaseBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void createTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .title("diploma")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCaseBuilder.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");
    }

    @Test
    public void updateTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .titleUpdate("diploma update")
                .build();

        Assert.assertEquals(testCaseStep.updateTestCase
                        (testCaseBuilder.getTitleUpdate()).getSuccessUpdateText().getText(),
                "Successfully updated the test case.");
    }

    @Test
    public void deleteTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        Assert.assertEquals(testCaseStep.deleteTestCase().);
    }
}
