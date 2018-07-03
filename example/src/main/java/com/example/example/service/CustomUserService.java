package com.example.example.service;

import com.example.example.domain.SysUser;
import com.example.example.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository userRepository;


    //重写方法验证用户名是否存在
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+s);
        System.out.println("username:" + user.getUsername() + "password:" + user.getPassword());
        return user;
    }
}
