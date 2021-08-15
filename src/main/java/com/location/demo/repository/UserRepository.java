package com.location.demo.repository;

import com.location.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    int countUsersByUsername(String username);
    @Query("select user from User user where user.role='ROLE_ADMIN'")
    List<User> findByRole();
    @Query("select u from User u where u.username=?1")
    User findByUsername(String s);
//
//    @Query("select b from User b where b.role=?2 and b.bookBorrowList.size > 0 and (?1 is null or b.username like %?1% or b.email like %?1% or b.phone like %?1%)")
//    List<User> findAllByRoleAndSearchValue(String s, String role);


    @Query("select new User(b.username,b.email,b.address) from User b WHERE b.role='ROLE_USER' and (?1 is null or b.username like %?1% or b.email like %?1% or b.address like %?1%)  ")
    List<User> findAllUsers(String s);
}
