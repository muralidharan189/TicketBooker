package com.ticket.booking.booker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ticket.booking.booker.entity.Booker;
import com.ticket.booking.booker.entity.HibernateUtil;
import com.ticket.booking.booker.exception.TicketException;
import com.ticket.booking.booker.pojo.Register;
import com.ticket.booking.booker.pojo.User;

public class BookerDaoImpl implements BookerDao{
	@Autowired
	BookerDao datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String loginValidation(String userName, String passWord) {

		/**************************************************************************************************************************/
		/***Plain SQL connection and Transaction**********************************************************************************/
		/*
		 * List<User> users = null; try { String sql =
		 * "select * from booker where username='" + userName + "' and password='" +
		 * passWord+ "'"; users = jdbcTemplate.query(sql, new UserMapper());
		 * if(null==users||users.isEmpty()) { throw new TicketException("DB error", new
		 * Exception()); } }catch(TicketException e){ System.out.println(
		 * "Error:"+e.getMessage()); return null;
		 * 
		 * } return users.get(0).getUsername();
		 */
		/**************************************************************************************************************************/
		/***Hibernate connection and Transaction**********************************************************************************/
		try {
			System.out.println("Executing query in hibernate----------->");
			String sql = "FROM Booker B WHERE B.userName='" + userName + "' and B.password='" +passWord+ "'";
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			TypedQuery<Booker> userdetails =session.createQuery(sql);
			if(null!=userdetails)
			{
				List<Booker> user=userdetails.getResultList();
				System.out.println(user);
				session.close();
				return user.get(0).getUserName();
			}
		}catch(Exception e) {
			System.out.println("Error in Hibernate:-------------->");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String checkUser(Register register) {
		List<User> users = null;
		try {
			String sql = "select * from booker where username='"+register.getUserName()+"'";
			users = jdbcTemplate.query(sql, new UserChecker());
			if(null==users||users.isEmpty()) {
				throw new TicketException("DB error", new Exception());
			}
		}catch(TicketException e){
			System.out.println(	"Error:"+e.getMessage());
			return null;

		}
		
		return users.get(0).getUsername();
	}

	@Override
	public String registerUser(Register register) {
		List<User> users = null;
		/*
		 * try { String sql = "insert into booker values(?,?,?,?,?,?,?,?,?)";
		 * jdbcTemplate.update(sql, new Object[] { register.getUserName(),
		 * register.getPassword(), register.getFirstname(), register.getLastname(),
		 * register.getEmail(),
		 * register.getAddress(),register.getAge(),register.getGender(),
		 * register.getPhone() });
		 * 
		 * }catch(Exception e){ System.out.println( "Error:"+e.getMessage()); return
		 * null;
		 * 
		 * }
		 */
		Booker book=new Booker(register.getUserName(),register.getPassword(), register.getFirstname(), register.getLastname(),
				register.getEmail(),register.getAddress(),register.getPhone(),register.getGender(),register.getDate(),register.getAge());
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(book);
			
		}catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
		session.close();
		return "success";
	}



	//*****************************************************************************************************************************************************
	//This contains all private classes implementation for DB
	//*****************************************************************************************************************************************************	
	private class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPhone(rs.getInt("phone"));
			return user;
		}
	}

	private class UserChecker implements RowMapper<User> {
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			return user;
		}
	}

	@Override
	public String loginUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}


}
