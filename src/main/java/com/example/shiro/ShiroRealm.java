package com.example.shiro;

import com.example.model.SysAuth;
import com.example.model.SysRole;
import com.example.model.SysUser;
import com.example.service.spi.ISysAuthService;
import com.example.service.spi.ISysRoleService;
import com.example.service.spi.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: liuhuan
 * @Description: realm
 * @date: 2018/12/13
 */
public class ShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysAuthService authService;

    /**
     * 配置权限 注入权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        System.out.println("--------权限配置-------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        try {
            //注入角色(查询所有的角色注入控制器）
            List<SysRole> list = sysRoleService.selectRoleByUser(user.getId());
            for (SysRole role: list){
                authorizationInfo.addRole(role.getSysRoleName());
            }
            //注入角色所有权限（查询用户所有的权限注入控制器）
            List<SysAuth> sysAuths = authService.queryByUserId(user.getId());
            for(SysAuth sysAuth:sysAuths){
                authorizationInfo.addStringPermission(sysAuth.getSysAuthPermission());
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return authorizationInfo;
    }

    /**
     * 用户验证
     * @param token 账户数据
     * @return
     * @throws AuthenticationException 根据账户数据查询账户。根据账户状态抛出对应的异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户的输入的账号
        String username = (String) token.getPrincipal();
        //这里需注意。看别人的教程有人是这样写的String password = (String) token.getCredentials();
        //项目运行的时候报错，发现密码不正确。后来进源码查看发现将密码注入后。Shiro会进行转义将字符串转换成字符数组。
        //源码：this(username, password != null ? password.toCharArray() : null, false, null);
        //不晓得是否是因为版本的原因，建议使用的时候下载源码进行查看
        String password = new String((char[]) token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser user = userService.selectByAccount(username);
        if(null == user){
            throw new UnknownAccountException();
        }else {
            if(password.equals(user.getUserPassword())){
                if(0 == user.getUserState()){
                    throw new LockedAccountException();
                }else if (2 == user.getUserState()){
                    throw new DisabledAccountException();
                }else{
                    SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(user,user.getUserPassword().toCharArray(),getName());
                    return authorizationInfo;
                }
            } else {
                throw new IncorrectCredentialsException();
            }
        }
    }

}
