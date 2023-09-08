//package com.jlstest.springbootdemo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import com.jlstest.springbootdemo.dao.PermissionDao;
//import com.jlstest.springbootdemo.dao.UserDao;
//import com.jlstest.springbootdemo.model.Permission;
//import com.jlstest.springbootdemo.model.User;
//import com.jlstest.springbootdemo.service.UserService;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-29 15:03
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Resource
//    private UserDao userDao;
//
//    @Resource
//    private PermissionDao permissionDao;
//
//    /**
//     * 获取用户信息
//     *
//     * @param username
//     *            用户名
//     * @return 用户信息
//     */
//    @Override
//    public User getUserByUsername(String username) {
//        return userDao.getByUsername(username);
//    }
//
//    /**
//     * Locates the user based on the username. In the actual implementation, the search may possibly
//     * be case sensitive, or case insensitive depending on how the implementation instance is
//     * configured. In this case, the <code>UserDetails</code> object that comes back may have a
//     * username that is of a different case than what was actually requested..
//     *
//     * @param username
//     *            the username identifying the user whose data is required.
//     * @return a fully populated user record (never <code>null</code>)
//     * @throws UsernameNotFoundException
//     *             if the user could not be found or the user has no GrantedAuthority
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 获取用户信息
//        User user = getUserByUsername(username);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (user != null) {
//            // 获取当前用户的权限
//            List<Permission> permissions = permissionDao.selectByUserId(user.getId());
//            // 设置权限
//            permissions.forEach(permission -> {
//                if (permission != null && !StringUtils.isEmpty(permission.getEnname())) {
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
//                    authorities.add(grantedAuthority);
//                }
//            });
//            // 封装成UserDetails的实现类
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//        } else {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//    }
//}
