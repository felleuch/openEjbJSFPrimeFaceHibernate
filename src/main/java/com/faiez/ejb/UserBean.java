package com.faiez.ejb;

import com.faiez.domain.User;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
@LocalBean
public class UserBean implements UserBeanLocal,UserBeanRemote{

	@PersistenceContext
	private EntityManager em;


    public String sayHello()
	{
		User user = em.find(User.class, new Long(1));
        return "Hello  "+user.getFullname();
    }


	public void addUser(User user){
		em.persist(user);
	}

	public List<User> getUsers(){
		Query query = em.createQuery("SELECT e FROM User e");
		return (List<User>) query.getResultList();
	}

}
