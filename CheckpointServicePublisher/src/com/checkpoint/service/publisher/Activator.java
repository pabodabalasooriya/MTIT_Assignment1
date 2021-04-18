package com.checkpoint.service.publisher;

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
		System.out.println("Registry service Checkpoint Started....");
	}

	private void registry() {
		// TODO Auto-generated method stub
		CheckpointService service = new CheckpointServiceImpl();
		context.registerService(CheckpointService.class, service, null);
	
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		 System.out.println("Checkpoint Service Stopped");
	}

}
