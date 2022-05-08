package com.laboratory.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		this.registry();
		System.out.println("Registry service Laboratory Started....");
	}

	private void registry() {
		// TODO Auto-generated method stub
		LaboratoryService service = new LaboratoryServiceImpl();
		context.registerService(LaboratoryService.class, service, null);
	
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		 System.out.println("Checkpoint Service Stopped");
	}

}
