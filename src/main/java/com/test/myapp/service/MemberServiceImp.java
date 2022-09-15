package com.test.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myapp.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;

    @Override
    public String getName(String id) {
        return memberDao.getName(id);
    }
}
