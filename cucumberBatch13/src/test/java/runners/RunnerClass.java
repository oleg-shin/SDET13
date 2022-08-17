package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features we use to provide the path of all the features file
        features = "src/test/resources/features/EmployeeSearch.feature",
        // glue is where we find implementations for gherkin steps
        // we provide the path of package where we defined all the steps
        glue = "steps",
        // if we set dry run to true, it stops the actual execution and
        // quickly scans all the steps whether they are implemented or not
        // to execute the script, set dry run to false
        dryRun = true,
        // it cleans your console output for cucumber test
        // if it has unreadable character in it
        // recommended is, to set it to true
        monochrome = true,
        // execute test cases with that specific tag only
        tags = "@smoke"
)
public class RunnerClass {
}
