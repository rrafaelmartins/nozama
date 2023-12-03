package com.example.nozama.model.pagamento;
import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.ProdutoCarrinho;
import com.example.nozama.model.user.User;

public class Pagamento {
    private  PagamentoStrategy strategy;
    private  User user;
    private  Carrinho carrinho;
    

    public void setStrategy(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public String processaPagamento (){
        double valorCompra = calculaTotalCarrinho();
        if (strategy.verificaInfo(user)){
            return strategy.executaPagamento(valorCompra);
        }
        return "Erro na compra";
    }

    private double calculaTotalCarrinho(){
        double total = 0;
        for (ProdutoCarrinho produtoCarrinho : carrinho.getProdutos()){
            total += produtoCarrinho.getQuantidade() * produtoCarrinho.getProduto().getPreco();
        }
        return total;
    }
}
