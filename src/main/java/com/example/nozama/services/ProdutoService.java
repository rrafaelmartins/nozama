package com.example.nozama.services;

import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    public Optional<Produto> obterPorId(Long id) {
        return produtoRepository.findById(id);
    }
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
