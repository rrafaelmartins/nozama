package com.example.nozama.model.carrinho.CarrinhoObserver;

public interface CarrinhoSubject {
    void registrarObservador(Observer observer);
    void removerObservador(Observer observer);
    void notificarObservadores();
}
