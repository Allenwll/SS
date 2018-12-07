package com.allen.service;

import com.allen.entity.UserInfo;

/**
 * 功能:
 *
 * @date: 2018-10-16 17:52
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public interface UserInfoService {
   public UserInfo findByUserName(String userName);
}
