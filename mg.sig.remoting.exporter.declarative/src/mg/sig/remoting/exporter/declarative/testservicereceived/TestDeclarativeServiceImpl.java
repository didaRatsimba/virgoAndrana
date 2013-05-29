/**
 *
 */
package mg.sig.remoting.exporter.declarative.testservicereceived;

import java.util.List;

import mg.sig.crossdomain.entities.UserEntity;
import mg.sig.http.bundle.HttpComponent;
import mg.sig.services.intf.user.IUserService;

/**
 * @author did
 * 
 */
public class TestDeclarativeServiceImpl {

	private IUserService userService;

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void clearUserService() {
		userService = null;
	}

	public void startup() {
		List<UserEntity> result = userService.findUsers();
		if (!result.isEmpty()) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
		HttpComponent comp = new HttpComponent();
		comp.startup();
	}

	public void shutdown() {
		System.out.println("shutdown");
	}

}
