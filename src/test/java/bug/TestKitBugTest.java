package bug;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

public class TestKitBugTest {
    @Test
    public void passes() {
        GradleRunner runner = createGradleRunner();
        assertTrue(runner.build().getOutput().contains("hello"));
    }

    @Test
    public void failsButShouldPass() {
        GradleRunner runner = createGradleRunner().withDebug(true);
        assertTrue(runner.build().getOutput().contains("hello"));
    }

    private GradleRunner createGradleRunner() {
        return GradleRunner.create().withProjectDir(new File("gradle-build")).withArguments("foo");
    }
}
