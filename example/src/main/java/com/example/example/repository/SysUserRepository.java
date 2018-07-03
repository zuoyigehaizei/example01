package com.example.example.repository;

import com.example.example.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);
}
