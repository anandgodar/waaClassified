package edu.waa.classified.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.waa.classified.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("")
    public User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    @Query("")
    public User findByUserName(@Param("userName") String userName);

}
