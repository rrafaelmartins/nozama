package com.example.nozama.services;

import com.example.nozama.model.user.User;
import com.example.nozama.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public Optional<User> obterPorId(int id) {
        return userRepository.findById(id);
    }

    public User salvar(User user) {
        System.out.println(user.toString());
        return userRepository.save(user);
    }

    public void deletar(int id) {
        userRepository.deleteById(id);
    }
}
