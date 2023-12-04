package com.example.nozama.model.carrinho.CarrinhoObserver;

import com.example.nozama.model.carrinho.Carrinho;

import lombok.ToString;
@ToString
public class CarrinhoObserver {
    private Carrinho carrinho;
    private Boolean verifica = false;
    public CarrinhoObserver(Carrinho carrinho) {
        this.carrinho = carrinho;
        this.verifica=true;
        carrinho.registrarObservador(this);
    }

    public void atualizar() {
        System.out.println("A interface do usuário foi atualizada!" );
        // Lógica de atualização da interface do usuário
    }
}

