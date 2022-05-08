package com.doctor.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistrationDoctor;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println();
		System.out.println();
		System.out.println("Doctor Service start");
		System.out.println();
		Activator.context = bundleContext;
		
		DoctorService doctorService = new DoctorServiceImpl();
		serviceRegistrationDoctor = bundleContext.registerService(DoctorService.class.getName(),doctorService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Doctor service stop");
		serviceRegistrationDoctor.unregister();
	}

}

