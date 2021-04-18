package com.store.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration storeReg;
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		  this.storeRegister();
	}
	
	private void storeRegister() {
	       StoreService service = (StoreService) new StoreServiceImpl();
	       storeReg = context.registerService(StoreService.class, service, null);
	       
	     
	   }
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		  System.out.println("Store service Stop");
		  storeReg.unregister();
	}

}
