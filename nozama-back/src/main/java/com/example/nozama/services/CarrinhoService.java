package com.example.nozama.services;

import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// CarrinhoService.java
@Service
public class CarrinhoService {
       @Autowired
    private CarrinhoRepository carrinhoRepository;
    public List<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }
    public Optional<Carrinho> obterPorId(Long id) {
        return carrinhoRepository.findById(id);
    }
    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }
    public void deletar(Long id) {
        carrinhoRepository.deleteById(id);
    }

    // Implemente os métodos para atualizar, recuperar e deletar itens do carrinho
}
