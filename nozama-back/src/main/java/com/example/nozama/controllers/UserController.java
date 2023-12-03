package com.example.nozama.controllers;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.user.User;
import com.example.nozama.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

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