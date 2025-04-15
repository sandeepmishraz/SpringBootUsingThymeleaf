package in.sp.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo repo; 	
	
	@Override
	public boolean registerUser(User user) 
	{
		try
		{
			repo.save(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loginUser(String email, String password) 
	{
		User validUser = repo.findByEmail(email);
		if(validUser!=null && validUser.getPassword().equals(password))
		{
			return validUser;
		}
		
		
		return null;
	}

}
