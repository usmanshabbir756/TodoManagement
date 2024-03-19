package com.usman.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        org.springframework.security.crypto.password.PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("usman"));
        System.out.println(passwordEncoder.encode("admin1"));
    }
}
