package org.wiperdog.demo_paxexam_bundle_test.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wiperdog.demo_paxexam_bundle_test.Vehicle;

public class Activator implements BundleActivator{

	public void start(BundleContext ctx) throws Exception {
		System.out.println("==========================START BUNDLE==========================");
		Vehicle car = new Car("lamborghini");
		ctx.registerService(Vehicle.class.getName(), car, null);
	}

	public void stop(BundleContext ctx) throws Exception {
		System.out.println("Leave your car!");
		ctx.ungetService(ctx.getServiceReference(Vehicle.class.getName()));
	}
}
