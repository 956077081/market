package com.pht.cust.dao;

import com.pht.cust.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UseDao {
     User getUserByName(@Param("userName") String userName);
}