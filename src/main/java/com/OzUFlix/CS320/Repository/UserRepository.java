package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findById(int id);

    @Query("SELECT u FROM User AS u WHERE u.name=?1 and u.password=?2")
    public User findUserByNameAndPassword(String name, String password);

    @Query("SELECT u FROM User AS u WHERE u.id=?1 and u.userType=1")
    public User getUserByUsertype(int id);

    @Query("SELECT r FROM Rent AS r inner join r.user as u WHERE u.id=?1")
    public List<Rent> getRent(int userId);

}
