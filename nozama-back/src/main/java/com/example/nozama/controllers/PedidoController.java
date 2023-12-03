package com.example.nozama.controllers;


import com.example.nozama.model.carrinho.ProdutoCarrinho;
import com.example.nozama.model.carrinho.ProdutoCarrinhoRepository;
import com.example.nozama.model.pedido.Pedido;
import com.example.nozama.model.pedido.PedidoRequestDTO;
import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.produto.ProdutoRepository;
import com.example.nozama.model.user.User;
import com.example.nozama.model.user.UserRepository;
import com.example.nozama.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UserRepository userRepository; // Injete o UserRepository aqui

    @Autowired
    private ProdutoRepository produtoRepository; // Injete o UserRepository aqui

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository; // Injete o UserRepository aqui

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obterPorId(@PathVariable Long id) {
        return pedidoService.obterPorId(id);
    }
    //Optional<User> userOptional = Optional.ofNullable(userRepository.findById(data.userId()));

    @PostMapping()
    public Pedido salvar(@RequestBody PedidoRequestDTO data) {
        // Busque o usuário pelo ID
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(data.userId()));

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Pedido pedido = new Pedido();
            pedido.setUser(user);
            List<ProdutoCarrinho> produtos = new ArrayList<>();

            for (Produto produto : data.produtos()) {
                Optional<Produto> produtoOptional = produtoRepository.findById(produto.getId());
                if (produtoOptional.isPresent()) {
                    ProdutoCarrinho temp = new ProdutoCarrinho(produtoOptional.get(),1);
                    produtoCarrinhoRepository.save(temp);
                    produtos.add(temp);
                } else {
                    throw new RuntimeException("Produto não encontrado");
                }
            }

            pedido.setProdutos(produtos);
            return pedidoService.salvar(pedido);

        } else {
            throw new RuntimeException("Usuário não encontrado"); // Trate a exceção adequadamente
        }
    }






    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }
}