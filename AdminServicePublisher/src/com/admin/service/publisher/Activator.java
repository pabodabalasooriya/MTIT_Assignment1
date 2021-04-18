package com.admin.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration adminreg;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		AdminService adminService =  new AdminServiceImpl();
		adminreg = bundleContext.registerService(AdminService.class.getName(), adminService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println(" Admin Service Stop");
		adminreg.unregister();
	}

}
