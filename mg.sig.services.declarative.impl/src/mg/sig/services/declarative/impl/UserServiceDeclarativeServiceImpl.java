/**
 *
 */
package mg.sig.services.declarative.impl;

import java.util.ArrayList;
import java.util.List;

import mg.sig.crossdomain.entities.UserEntity;
import mg.sig.services.intf.user.IUserService;

/**
 * @author did
 * 
 */
public class UserServiceDeclarativeServiceImpl implements IUserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mg.sig.services.intf.user.IUserService#findUsers()
	 */
	@Override
	public List<UserEntity> findUsers() {
		UserEntity user = new UserEntity();
		user.setName("here is my name");
		List<UserEntity> result = new ArrayList<UserEntity>();
		result.add(user);
		return result;
	}

}
