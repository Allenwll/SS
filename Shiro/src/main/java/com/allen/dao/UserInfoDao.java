package com.allen.dao;

import com.allen.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 功能:
 *
 * @date: 2018-10-16 17:56
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public interface UserInfoDao extends CrudRepository<UserInfo,Long>{
    public UserInfo findByUserName(String userName);
}
