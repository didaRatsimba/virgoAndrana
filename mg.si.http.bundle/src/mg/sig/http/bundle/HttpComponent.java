/**
 *
 */
package mg.sig.http.bundle;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;

import mg.sig.http.bundle.servlet.UserServlet;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

/**
 * @author did
 * 
 */
public class HttpComponent {

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
			UserServlet servlet = new UserServlet();
			if (http == null) {
				System.out.println("ito");
			}
			if (url.getFile() == null) {
				System.out.println("eto le null");
			}
			http.registerServlet("/" + url.getFile(), servlet, null, null);
			System.out.println("servlet enregistré " + url.getFile());
		} catch (ServletException se) {
			System.out.println("se " + se.getMessage());
		} catch (NamespaceException ne) {
			System.out.println("ne " + ne.getMessage());
		} catch (MalformedURLException murle) {
			System.out.println("murle " + murle.getMessage());
		} catch (NullPointerException npe) {
			System.out.println("npe " + npe.getMessage());
			npe.printStackTrace();
		}
	}

}
