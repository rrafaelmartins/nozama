package com.example.nozama.model.pagamento;
import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.ProdutoCarrinho;
import com.example.nozama.model.user.User;

public class Pagamento {
    private  PagamentoStrategy strategy;
    private  User user;
    private  Carrinho carrinho;

    public Pagamento(PagamentoStrategy strategy, User user, Carrinho carrinho) {
        this.strategy = strategy;
        this.user = user;
        this.carrinho = carrinho;
    }

    public void setStrategy(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public PagamentoResponseStatus processaPagamento (){
        double valorCompra = calculaTotalCarrinho();
        if (strategy.verificaInfo(user)){
            return strategy.executaPagamento(valorCompra);
        }
        return new PagamentoResponseStatus(400, "Erro no pagamento");
    }

    private double calculaTotalCarrinho(){
        double total = 0;
        for (ProdutoCarrinho produtoCarrinho : carrinho.getProdutos()){
            total += produtoCarrinho.getQuantidade() * produtoCarrinho.getProduto().getPreco();
        }
        return total;
    }
}
