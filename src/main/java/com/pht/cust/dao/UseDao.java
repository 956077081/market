package com.pht.cust.dao;

import com.pht.cust.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface UseDao {
     User getUserByName(@Param("userName") String userName);
     int insert(User user);


    User getUserByCode(@Param("code")String code);

    void updateUserStatus(@Param("code") String usercode,@Param("status") String newStatus);

    void updatePassword(@Param("code") String code, @Param("password") String newPassword);
}