package com.example.nozama.services;

import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.CarrinhoRepository;
import com.example.nozama.model.carrinho.CarrinhoObserver.CarrinhoSubject;
import com.example.nozama.model.carrinho.CarrinhoObserver.Observer;

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
