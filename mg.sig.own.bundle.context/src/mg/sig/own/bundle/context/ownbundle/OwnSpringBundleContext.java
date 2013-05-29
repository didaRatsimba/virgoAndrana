/**
 *
 */
package mg.sig.own.bundle.context.ownbundle;

import javax.servlet.ServletContext;

import org.osgi.framework.BundleContext;
import org.springframework.context.ApplicationContext;
import org.springframework.osgi.context.ConfigurableOsgiBundleApplicationContext;
import org.springframework.osgi.web.context.support.OsgiBundleXmlWebApplicationContext;

/**
 * @author did
 * 
 */
public class OwnSpringBundleContext extends OsgiBundleXmlWebApplicationContext {

	private static BundleContext contextFromActivator;

	public OwnSpringBundleContext() {
		super();
	}

	public OwnSpringBundleContext(BundleContext bundleContext) {
		this();
		OwnSpringBundleContext.contextFromActivator = bundleContext;
		// ApplicationContext parent = getParent();
		// if (getServletContext() != null) {
		// Object bundleContextFromServletContext = getServletContext()
		// .getAttribute("osgi-bundlecontext");
		// if (bundleContextFromServletContext != null) {
		// setBundleContext((BundleContext) bundleContextFromServletContext);
		// }
		// }
		//
		// else if (parent instanceof ConfigurableOsgiBundleApplicationContext)
		// {
		// setBundleContext(((ConfigurableOsgiBundleApplicationContext) parent)
		// .getBundleContext());
		// }
		// else {
		setBundleContext(contextFromActivator);
		// }

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.osgi.web.context.support.
	 * OsgiBundleXmlWebApplicationContext
	 * #setServletContext(javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		ApplicationContext parent = getParent();
		// setServletContext(servletContext);
		if (getBundleContext() == null) {
			if (servletContext != null) {
				Object bundleContext = servletContext
						.getAttribute("osgi-bundlecontext");
				if (bundleContext != null) {
					setBundleContext((BundleContext) bundleContext);
				}
			} else if (parent instanceof ConfigurableOsgiBundleApplicationContext) {
				setBundleContext(((ConfigurableOsgiBundleApplicationContext) parent)
						.getBundleContext());
			} else {
				setBundleContext(contextFromActivator);
			}
		}
		super.setServletContext(servletContext);
	}

}
