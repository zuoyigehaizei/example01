package com.example.example.config;

import com.example.example.utils.PasswordUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }

}
