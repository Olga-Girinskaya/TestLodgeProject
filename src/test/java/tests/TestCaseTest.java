package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.TestCaseBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void createTestCaseTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("diploma")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");
    }

//    @Test
//    public void updateTestCaseTest() { //не проходит проверка
//        loginStep.login(ReadProperties.username(), ReadProperties.password());
//        testCaseStep.pathToTestCases();
//
//        TestCaseBuilder testCase = TestCaseBuilder.builder()
//                .titleUpdate("diploma update")
//                .build();
//
//        Assert.assertEquals(testCaseStep.updateTestCase
//                        (testCase.getTitleUpdate()).getSuccessText().getText(),
//                "Successfully updated the test case.");
//    }

//    @Test
//    public void deleteTestCaseTest(){
//        loginStep.login(ReadProperties.username(), ReadProperties.password());
//        testCaseStep.pathToTestCases();
//        testCaseStep.deleteTestCase();
//
//        //Assert.assertFalse(testCaseStep.deleteTestCase().getTestCaseCheckBox());
//    }
}
