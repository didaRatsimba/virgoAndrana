/**
 *
 */
package simpleclientmain;

import mg.sig.services.intf.user.IUserService;

import org.osgi.util.tracker.ServiceTracker;

/**
 * @author did
 * 
 */
public class ThreadWawawa extends Thread {

	private static final long TIMER = 5000;

	private ServiceTracker<?, ?> userServiceTracker;

	public ThreadWawawa(ServiceTracker<?, ?> userServiceTracker) {
		this.userServiceTracker = userServiceTracker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#start()
	 */
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (!super.isInterrupted()) {
			try {
				IUserService userService = (IUserService) userServiceTracker
						.getService();
				if (userService != null) {
					System.out.println("non null");
				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					if (!super.isInterrupted()) {
						sleep(TIMER);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#interrupt()
	 */
	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		super.interrupt();
	}

}
