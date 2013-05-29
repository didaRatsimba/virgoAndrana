import mg.sig.services.intf.user.IUserService;

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 *
 */

/**
 * @author did
 * 
 */
public class SimpleMainClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ApplicationContext apcont = new FileSystemXmlApplicationContext(
		// "D:\\eclipseWS\\org.dynaresume.simplemainremotingclient\\src\\clientContext.xml");
		// IUserService service = (IUserService) apcont.getBean("userService");
		// if (service != null) {
		// System.out.println("here");
		// System.out.println(service.getClass());
		// for (UserEntity u : service.findUsers()) {
		// if (u != null) {
		// System.out.println(u.getName());
		// } else {
		// System.out.println("null user");
		// }
		// }
		// }
		HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
		httpInvokerProxyFactoryBean.setServiceInterface(IUserService.class);
		httpInvokerProxyFactoryBean
				.setServiceUrl("http://localhost:8080/dynaresume-server/remoting/UserService");
		httpInvokerProxyFactoryBean.afterPropertiesSet();
		IUserService serv = (IUserService) httpInvokerProxyFactoryBean
				.getObject();
		if (serv != null) {
			System.out.println("aaa");
			System.out.println(serv.findUsers().size());
		}
		// TestDeclarativeServiceImpl test = new TestDeclarativeServiceImpl();
		// if (test.getUserService() != null) {
		// System.out.println("tsy null ny service");
		// }

	}

}
