package com.faiez.ejb;

/**
 * Created by faiez.elleuch on 20/12/13.
 */

import com.faiez.domain.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserBeanRemote {

    public String sayHello();

	public void addUser(User user);

	public List<User> getUsers();
}
