package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Config.JwtProvider;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class ServiceImplementation implements UserService {
	@Autowired
private  UserRepository repository;
	@Override
	public User registerUser( User u) {
	   return repository.save(u);

	}

	@Override
	public User findUserById(int id) throws Exception  {

		Optional<User> u1= repository.findById(id);
		if(u1.isEmpty()) {
			throw new Exception("Id not found");
			
		}else {
			return u1.get();
		}
	}

	@Override
	public User findUserByEmail(String email) {

		 User user=repository.findByEmail(email);
		 return user;
	}

	@Override
	public  User followUser(int recUserId, int id2) throws Exception {
		User recUser= findUserById(recUserId);
		User user2= findUserById(id2);
		user2.getFollowers().add(recUser.getId());
		recUser.getFollowing().add(user2.getId());
		repository.save(recUser);
		repository.save(user2);
		return recUser;



	}

	@Override
	public List<User> searchUsers(String qry) {
		return repository.searchUser(qry);

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User updateUser(User u, int id) throws Exception {
	 Optional<User>   users=repository.findById(id);
	 if(users.isEmpty()) {
		 throw new Exception("User not found this id");
	 }

		User oldUser=users.get();
		if(oldUser.getFirstname()!=null) {
			oldUser.setFirstname(u.getFirstname());
		}
		if(oldUser.getLasttname()!=null) {
			oldUser.setLasttname(u.getLasttname());
		}
		if(oldUser.getEmail()!=null) {
			oldUser.setEmail(u.getEmail());
		}
		if(oldUser.getGender()!=null) {
			oldUser.setFirstname(u.getGender());
		}
		User updateUser=repository.save(oldUser);
		return updateUser;
	}

	@Override
	public User getUserfromTocken(String jwt) {
		String email=JwtProvider.getEmailFromJwtToken(jwt);
		User user=repository.findByEmail(email);
		
		return user;
	}

}
