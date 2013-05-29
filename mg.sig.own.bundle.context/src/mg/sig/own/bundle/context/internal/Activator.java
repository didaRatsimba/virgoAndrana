package mg.sig.own.bundle.context.internal;

import mg.sig.own.bundle.context.ownbundle.OwnSpringBundleContext;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private static Activator plugin;

	private OwnSpringBundleContext ownSpringBundleContext;

	static BundleContext getContext() {
		return context;
	}

	public Activator() {
		plugin = this;
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
		ownSpringBundleContext = new OwnSpringBundleContext(bundleContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		ownSpringBundleContext.setBundleContext(null);
		ownSpringBundleContext.destroy();
		Activator.context = null;
	}

	public static Activator getDefault() {
		return plugin;
	}

}
