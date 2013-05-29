package simpleclientmain;

import mg.sig.services.intf.user.IUserService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
	private ServiceTracker<?, ?> userServiceTracker;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
		userServiceTracker = new ServiceTracker(context, "userService", null);
		if (userServiceTracker != null) {
			System.out.println("serviceTracker != null");
			userServiceTracker.open();
		}
		IUserService service = (IUserService) userServiceTracker.getService();
		if (service != null) {
			service.findUsers();
			System.out.println("ici");
		} else {
			System.out.println("ato");
		}
		ServiceReference<?> ref = context.getServiceReference("userService");
		if (ref != null) {
			System.out.println("ref");
		}

		// ThreadWawawa wawawa = new ThreadWawawa(userServiceTracker);
		// wawawa.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
		// if (userServiceTracker != null) {
		// userServiceTracker.close();
		// }
	}

}
