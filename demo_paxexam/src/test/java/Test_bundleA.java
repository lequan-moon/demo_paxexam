import static org.ops4j.pax.exam.CoreOptions.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.wiperdog.demo_paxexam_bundle_test.Vehicle;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class Test_bundleA {
	
	@Inject
	private BundleContext context;
	
	@Configuration
	public Option[] config() {
		return options(
				cleanCaches(true),
				frameworkStartLevel(6),
				systemProperty("felix.home").value(System.getProperty("user.dir")),
				mavenBundle("org.wiperdog","demo_paxexam_bundle_test").start(),
				junitBundles()
		);
	}

	@Test
	public void testcase01() {
		Vehicle car = (Vehicle)context.getService(context.getServiceReference("org.wiperdog.demo_paxexam_bundle_test.Vehicle"));
		Assert.assertEquals("lamborghini", car.getModel());
	}

	@Before
	public void prepare() {

	}

	@After
	public void finish() {

	}
}
