package com.example.nozama.model.carrinho.CarrinhoObserver;


public class InterfaceDoUsuario implements Observer {
    @Override
    public void atualizar(CarrinhoSubject carrinho) {
        System.out.println("O carrinho foi atualizado! Itens: "); // + ((Carrinho) carrinho).getItens());
        // Lógica de atualização da interface do usuário
    }
}
