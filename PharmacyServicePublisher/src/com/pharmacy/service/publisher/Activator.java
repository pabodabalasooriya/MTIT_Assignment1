package com.pharmacy.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration pharmacyReg;
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Pharmacy service start");
		Activator.context = bundleContext;
		  this.pharmacyRegister();
	}
	
	private void pharmacyRegister() {
	       PharmacyService service = (PharmacyService) new PharmacyServiceImpl();
	       pharmacyReg = context.registerService(PharmacyService.class, service, null);
	       
	     
	   }
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		  System.out.println("Pharmacy service Stop");
		  pharmacyReg.unregister();
	}

}
