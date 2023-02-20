package orion.Dayoff.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import orion.Dayoff.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	User findByUserName(String userName);


}
