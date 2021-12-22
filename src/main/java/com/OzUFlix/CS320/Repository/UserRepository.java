package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findById(int id);

}
