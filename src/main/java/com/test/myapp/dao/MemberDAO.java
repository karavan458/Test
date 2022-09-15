package com.test.myapp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
    public String getName(@Param("id")String id);
}
