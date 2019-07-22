import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestComplementOfSet.class, TestIsMemberOfSet.class,
		TestIsSubsetOfSet.class, TestSizeOfSet.class, TestUnionOfSets.class })

public class AllTests {

}
