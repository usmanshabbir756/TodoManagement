package com.usman.todo.service;

import com.usman.todo.dto.LoginDto;
import com.usman.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
