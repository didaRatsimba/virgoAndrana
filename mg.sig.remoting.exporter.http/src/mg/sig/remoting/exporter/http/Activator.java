package mg.sig.remoting.exporter.http;

import mg.sig.services.intf.user.IUserService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker<?, ?> tracker;

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
		tracker = new ServiceTracker(bundleContext, IUserService.class, null);
		if (tracker != null) {
			tracker.open();
			IUserService service = (IUserService) tracker.getService();
			if (service != null) {
				System.out.println("service non null");
				if (!service.findUsers().isEmpty()) {
					System.out.println(service.findUsers().size());
				}
			} else {
				System.out.println("service null ici déjà");
			}
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
		tracker.close();
		tracker = null;
		Activator.context = null;

	}

}
