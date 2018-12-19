package com.happy.Controllers;

import com.happy.DTO.LoginDTO;
import com.happy.Models.Login;
import com.happy.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/logins")
    public List<Login> getAllLogins(){
        return loginService.getAllLogins();
    }

    @GetMapping("/login/{id}")
    public Login getLogin(@PathVariable Integer id){
        return loginService.getLoginById(id);
    }

    @GetMapping("/loginName/{name}")
    public Login getLoginByName(@PathVariable String name){
        return loginService.getLoginByName(name);
    }

    @PostMapping("/logins")
    public Login newLogin(@RequestBody LoginDTO login){
        return loginService.newLogin(login);
    }

    @PutMapping("/login/{id}")
    public Login addOrReplaceLogin(@RequestBody LoginDTO login, @PathVariable Integer id){
        return loginService.addOrReplaceLogin(login, id);
    }

    @DeleteMapping("/login/{id}")
    public void deleteLogin(@PathVariable Integer id){
        loginService.deleteLogin(id);
    }
}
