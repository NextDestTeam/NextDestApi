package com.happy.Services;

import com.happy.DTO.LoginDTO;
import com.happy.Exceptions.LoginNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Models.Login;
import com.happy.Models.Person;
import com.happy.Repositories.LoginRepository;
import com.happy.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PersonRepository personRepository;

    public List<Login> getAllLogins(){
        return loginRepository.findAll();
    }

    public Login getLoginById(Integer id){
        return loginRepository.findById(id)
                .orElseThrow(() -> new LoginNotFoundException(id));
    }

    public Login getLoginByName(String name){
        return loginRepository.findByLogin(name);
    }

    public Login newLogin(LoginDTO newLogin) {
        return getLogin(newLogin);
    }

    public Login addOrReplaceLogin(LoginDTO newLogin, Integer id){
        return loginRepository.findById(id)
                .map(login -> {
                    login.setPassword(newLogin.getPassword());
                    return loginRepository.save(login);
                }).orElseGet(() ->{
                    return getLogin(newLogin);
                });
    }

    public void deleteLogin(Integer id){
        loginRepository.deleteById(id);
    }

    private Login getLogin(LoginDTO newLogin) {
        Login login = new Login();
        Person person = personRepository.findById(newLogin.getPersonId())
                .orElseThrow(() -> new PersonNotFoundException(newLogin.getPersonId()));

        login.setLogin(newLogin.getLogin());
        login.setPassword(newLogin.getPassword());
        login.setPersonId(person);
        return loginRepository.save(login);
    }
}
