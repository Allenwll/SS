package com.allen.config;

import com.allen.entity.SysPermission;
import com.allen.entity.SysRole;
import com.allen.entity.UserInfo;
import com.allen.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * 功能:
 *
 * @date: 2018-10-16 17:27
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class MyShiroRealm extends AuthorizingRealm{
    
    @Resource
    private UserInfoService userInfoService;
    
    /**
     * 得到权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthenticationInfo()");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        UserInfo userInfo= (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }
    
    
    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证-->MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的账号
        String userName= (String) token.getPrincipal();
        System.out.println("密码:"+token.getCredentials());
        //通过userName从数据库中查找User
        //可做缓存， 不做 Shiro有自己的时间间隔机制 2分钟内不会重复执行该方法
        UserInfo userInfo=userInfoService.findByUserName(userName);
        System.out.println("用户信息："+userInfo);
        if(null==userInfo){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
            userInfo,//用户名
            userInfo.getPassword(),//密码
            ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=userName+salt
            getName() //realm name
            );
        return authenticationInfo;
    }
}
