package mg.sig.remoting.importer.http;

import mg.sig.services.intf.user.IUserService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	ServiceRegistration<?> reg = null;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		reg = bundleContext.registerService("userService", IUserService.class,
				null);
		ServiceReference<?> ref = bundleContext
				.getServiceReference(IUserService.class);
		if (ref != null) {
			System.out.println("ok");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		reg = null;
		Activator.context = null;

	}

}
