/**
 *
 */
package mg.sig.allin.andrana.user;

import java.util.ArrayList;
import java.util.List;

import mg.sig.crossdomain.entities.UserEntity;
import mg.sig.services.intf.user.IUserService;

/**
 * @author did
 * 
 */
public class UserServiceImpl implements IUserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mg.sig.services.intf.user.IUserService#findUsers()
	 */
	@Override
	public List<UserEntity> findUsers() {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("the name");
		List<UserEntity> result = new ArrayList<UserEntity>();
		result.add(userEntity);
		return result;
	}

}
