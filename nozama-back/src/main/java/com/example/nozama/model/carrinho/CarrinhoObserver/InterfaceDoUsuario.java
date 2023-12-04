package com.example.nozama.model.carrinho.CarrinhoObserver;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.nozama.model.carrinho.Carrinho;

// InterfaceDoUsuario.java (View)
public class InterfaceDoUsuario implements CarrinhoObserver {

    private Carrinho carrinho;

    public InterfaceDoUsuario(Carrinho carrinho) {
        this.carrinho = carrinho;
        carrinho.registrarObservador(this);
    }

    @Override
    public void atualizar() {
        System.out.println("A interface do usuário foi atualizada!" );
        // Lógica de atualização da interface do usuário
    }
}
