package com.lyssn.useroperation.dao;

import java.math.BigInteger;
import java.util.Collection;
import com.lyssn.useroperation.entity.User;
import com.lyssn.useroperation.exception.UserException;

public interface IUserDAO 
{
	public Collection<User> displayAllUsers() throws UserException;
	public User findUserByID(BigInteger userid) throws UserException;
	public User updateUserByID(BigInteger userid) throws UserException;
	public User createUser() throws UserException;
	public User deleteUser(BigInteger userid) throws UserException;
}
