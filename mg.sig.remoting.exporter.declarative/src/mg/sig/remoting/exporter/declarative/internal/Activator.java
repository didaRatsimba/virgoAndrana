/**
 *
 */
package mg.sig.remoting.exporter.declarative.internal;

import mg.sig.remoting.exporter.declarative.testservicereceived.TestDeclarativeServiceImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author did
 * 
 */
public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		TestDeclarativeServiceImpl test = new TestDeclarativeServiceImpl();
		test.startup();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
