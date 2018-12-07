package com.allen.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能:
 *
 * @date: 2018-10-16 18:09
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    
    /**
     * 用户查询
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理
    public String userInfo(){
        return "userInfo";
    }
    
    /**
     * 用户添加
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理
    public String userAdd(){
        return "userInfoAdd";
    }
    
    /**
     * 用户添加
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理
    public String userDel(){
        return "userInfoDel";
    }
}
