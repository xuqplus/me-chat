package cn.xuqplus.shiro;

import cn.xuqplus.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.AllPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017-04-08.
 */
public class MyAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**
         * subject.login(token)中的token需要和这里的一致
         * ,才能登录成功
         */
        String user_email = authenticationToken.getPrincipal().toString();
        String user_password =
                userMapper.findPasswordByEmail(user_email);
        //String user_password = authenticationToken.getCredentials().toString();
        //User user = userMapper.findUserByEmailAndPassword(user_email, user_password);
        return new SimpleAuthenticationInfo(user_email, user_password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        /**
         * 角色
         */
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        //authorizationInfo.setRoles(roles);
        /**
         * 对象权限
         */
        Set<Permission> permissions = new HashSet<>();
        permissions.add(new AllPermission());
        //authorizationInfo.setObjectPermissions(permissions);

        /**
         * 字符权限
         */
        Set<String> strings = new HashSet<>();
        strings.add("admin:read");
        strings.add("admin:create");
        authorizationInfo.setStringPermissions(strings);
        return authorizationInfo;
    }
}