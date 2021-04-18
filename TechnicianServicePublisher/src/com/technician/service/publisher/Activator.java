package com.technician.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistrationTechnician;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Technician Service start");
		Activator.context = bundleContext;
		
		TechnicianService technicianService = new TechnicianServiceImpl();
		serviceRegistrationTechnician = bundleContext.registerService(TechnicianService.class.getName(),technicianService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Technician service stop");
		serviceRegistrationTechnician.unregister();
	}

}
