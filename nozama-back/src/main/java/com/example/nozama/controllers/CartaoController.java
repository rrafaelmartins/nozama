package com.example.nozama.controllers;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.pagamento.cartao.CartaoRequestDTO;
import com.example.nozama.model.user.User;
import com.example.nozama.model.user.UserRepository;
import com.example.nozama.services.CartaoService;
import com.example.nozama.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository; 

    @GetMapping
    public List<Cartao> listarTodos() {
        return cartaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cartao> obterPorId(@PathVariable Long id) {
        return cartaoService.obterPorId(id);
    }

    @PostMapping()
    public String salvar(@RequestBody CartaoRequestDTO data) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(data.userId()));

        Cartao cartao = new Cartao(data);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            cartaoService.salvar(cartao);
            user.setCartao(cartao);
            cartao.setUsuario(user);
            userService.salvar(user);
        }
        
        return "cartao salvo com sucesso";
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cartaoService.deletar(id);
    }
}