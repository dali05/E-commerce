package org.sid.e_commercebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sid.e_commercebackend.beans.Address;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.User;
import org.sid.e_commercebackend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	@Override
	public User getByEmail(String email) {
		String query = "From User  WHERE email  = :email";

		try {
			User user =sessionFactory.getCurrentSession()
					.createQuery(query, User.class)
					    .setParameter("email", email)
						    .getSingleResult();
			  return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
   
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :Billing";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("user", user)
						.setParameter("Billing", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("user", user)
						.setParameter("shipping", true)
						.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
