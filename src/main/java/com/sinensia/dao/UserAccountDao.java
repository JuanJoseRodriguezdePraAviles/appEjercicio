package com.sinensia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contracts.IDao;
import com.sinensia.model.UserAccount;

public class UserAccountDao extends BaseDao implements IDao<UserAccount>{
private Connection connect;
	
	@Override
	public int add(UserAccount userAccount) throws SQLException {
		int idCategoria = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement(
					"INSERT INTO userAccount(userAccountId, nombre, apellidos, fechaNacimiento, email, fechaRegistro) VALUE (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, userAccount.getUserAccountId());
			preparedStatement.setString(2, userAccount.getNombre());
			preparedStatement.setString(3, userAccount.getApellidos());
			preparedStatement.setDate(4, Date.valueOf(userAccount.getFechaNacimiento()));
			preparedStatement.setString(5, userAccount.getEmail());
			preparedStatement.setDate(6, Date.valueOf(userAccount.getFechaRegistro()));
			
			preparedStatement.executeUpdate();
			rsKey = preparedStatement.getGeneratedKeys();
			rsKey.next();
			idCategoria = rsKey.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rsKey != null) {
				rsKey.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		
		return idCategoria;
	}

	@Override
	public int modify(UserAccount userAccount) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserAccount> get() throws SQLException {
		PreparedStatement preparedStatement = null;
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		ResultSet rs = null;
		
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM userAccount");
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				UserAccount userAccount = new UserAccount(rs.getInt("userAccountId"), rs.getString("nombre"), rs.getString("apellidos"), rs.getDate("fechaNacimiento").toLocalDate(), rs.getString("email"), rs.getDate("fechaRegistro").toLocalDate());
				userAccounts.add(userAccount);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		
		return userAccounts;
	}

	@Override
	public UserAccount getById(int id) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		UserAccount userAccount = null;
		
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement(
					"SELECT * FROM userAccount WHERE userAccountId = ?");
			preparedStatement.setInt(1, id);
			
			rs = preparedStatement.executeQuery();
			rs.next();
			
			userAccount = new UserAccount(rs.getInt("userAccountId"), rs.getString("nombre"), rs.getString("apellidos"), rs.getDate("fechaNacimiento").toLocalDate(), rs.getString("email"), rs.getDate("fechaRegistro").toLocalDate());
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		
		return userAccount;
	}

	@Override
	public int remove(int id) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connect = super.getconnection();
			preparedStatement = connect.prepareStatement("DELETE FROM useraccount WHERE userAccountId = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connect != null) {
				connect.close();
			}
		}
		
		return id;
	}
}
