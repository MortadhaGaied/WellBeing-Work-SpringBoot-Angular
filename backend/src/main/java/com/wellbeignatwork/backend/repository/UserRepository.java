package com.wellbeignatwork.backend.repository;


import com.wellbeignatwork.backend.entity.Message;
import com.wellbeignatwork.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
List<User>findUsersByMessagesIsNull();

}
