package com.faiez.ejb;

/**
 * Created by faiez.elleuch on 20/12/13.
 */
import com.faiez.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserBeanLocal {

    public String sayHello();
	public void addUser(User user);
	public List<User> getUsers();
}
