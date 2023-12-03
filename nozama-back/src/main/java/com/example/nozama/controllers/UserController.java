package com.example.nozama.controllers;

import com.example.nozama.model.user.User;
import com.example.nozama.model.user.UserRepository;
import com.example.nozama.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listarTodos() {
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obterPorId(@PathVariable int id) {
        return userService.obterPorId(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User criarUsuario(@RequestBody User usuario) {
        return userService.salvar(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestBody User usuario) {
        String email = usuario.getEmail();
        String password = usuario.getSenha();

        Optional<User> userOptional = userRepository.findByEmailAndSenha(email, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getSenha().equals(password)) {
                return ResponseEntity.ok("Login bem-sucedido");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable int id, @RequestBody User usuario) {
        return userService.obterPorId(id)
                .map(usuarioExistente -> {
                    usuario.setId((long) id);
                    User usuarioAtualizado = userService.salvar(usuario);
                    return ResponseEntity.ok().body(usuarioAtualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        return userService.obterPorId(id)
                .map(usuario -> {
                    userService.deletar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}