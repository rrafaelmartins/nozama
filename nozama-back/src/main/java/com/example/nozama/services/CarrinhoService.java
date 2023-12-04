package com.example.nozama.services;

import com.example.nozama.model.EnvioFacade.EnvioFacade;
import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.CarrinhoRepository;
import com.example.nozama.model.carrinho.ProdutoCarrinho;
import com.example.nozama.model.carrinho.ProdutoCarrinhoRepository;
import com.example.nozama.model.carrinho.CarrinhoObserver.CarrinhoSubject;
import com.example.nozama.model.carrinho.CarrinhoObserver.Observer;
import com.example.nozama.model.envio.Envio;
import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.produto.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// CarrinhoService.java
@Service
public class CarrinhoService implements CarrinhoSubject {
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

     @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;
    
    private List<Observer> observers = new ArrayList<>();

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
    public void adicionarProduto(Long id, Long produtoId, int quantidade){
        Carrinho carrinho;
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);

        Produto produto;
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if (carrinhoOptional.isPresent() && produtoOptional.isPresent() ){
            carrinho = carrinhoOptional.get();
            produto = produtoOptional.get();
            ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(produto, quantidade);
            produtoCarrinhoRepository.save(produtoCarrinho);
            carrinho.AtualizarProduto(produtoCarrinho);
            carrinhoRepository.save(carrinho);
        }
       
    }
    
    //Observer
    public void registrarObservador(Observer observer) {
        observers.add(observer);
    }
    public void removerObservador(Observer observer) {
        observers.remove(observer);
    }
    public void notificarObservadores() {
        for (Observer observer : observers) {
            observer.atualizar(this);
        }
    }


    // Implemente os métodos para atualizar, recuperar e deletar itens do carrinho
}
