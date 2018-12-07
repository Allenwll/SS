package com.allen.service.impl;

import com.allen.dao.UserInfoDao;
import com.allen.entity.UserInfo;
import com.allen.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能:
 *
 * @date: 2018-10-16 17:54
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoDao userInfoDao;
    
    @Override
    public UserInfo findByUserName(final String userName) {
        System.out.println("根据用户名查找User");
        return userInfoDao.findByUserName(userName);
    }
}
