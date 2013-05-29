/**
 *
 */
package mg.sig.services.intf.user;

import java.util.List;

import mg.sig.crossdomain.entities.UserEntity;

/**
 * @author did
 * 
 */
public interface IUserService {

	List<UserEntity> findUsers();

}
