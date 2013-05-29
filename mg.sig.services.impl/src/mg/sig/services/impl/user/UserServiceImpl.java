/**
 *
 */
package mg.sig.services.impl.user;

import java.util.ArrayList;
import java.util.List;

import mg.sig.crossdomain.entities.UserEntity;
import mg.sig.services.intf.user.IUserService;

/**
 * @author did
 * 
 */
// @Service("userService")
public class UserServiceImpl implements IUserService {

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
