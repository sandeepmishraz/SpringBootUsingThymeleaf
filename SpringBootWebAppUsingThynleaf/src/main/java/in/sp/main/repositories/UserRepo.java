package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;

public interface UserRepo extends JpaRepository<User, Long>
{
	User findByEmail(String email);
}
