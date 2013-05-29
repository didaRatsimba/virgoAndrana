/**
 *
 */
package mg.sig.remoting.exporter.declarative.bundle;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;

import mg.sig.remoting.exporter.declarative.servlet.UserServlet;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

/**
 * @author did
 * 
 */
public class Component {

	private HttpService http;
	private String servletAlias;

	/**
	 * @param http
	 *            the http to set
	 */
	public void setHttp(HttpService http) {
		this.http = http;
	}

	public void shutdown() {
		http.unregister(servletAlias);
	}

	public void startup() {
		try {
			String servletRoot = "http://localhost:8080/user";
			URL url = new URL(servletRoot);
			http.registerServlet("/" + url.getFile(), new UserServlet(), null,
					null);
			System.out.println("servlet enregistré " + url.getFile());
		} catch (ServletException se) {
			System.out.println("se " + se.getMessage());
		} catch (NamespaceException ne) {
			System.out.println("ne " + ne.getMessage());
		} catch (MalformedURLException murle) {
			System.out.println("murle " + murle.getMessage());
		}
	}
}
