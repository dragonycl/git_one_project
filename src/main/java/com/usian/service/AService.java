package com.usian.service;

import com.usian.dao.ADao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService {

    @Autowired
    private ADao aDao;

    public void addUser() {
        aDao.addUser();
    }
}
