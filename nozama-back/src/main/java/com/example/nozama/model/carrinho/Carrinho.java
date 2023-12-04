package com.example.nozama.model.carrinho;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.nozama.model.carrinho.CarrinhoRequestDTO;
import com.example.nozama.model.carrinho.CarrinhoObserver.CarrinhoObserver;
import com.example.nozama.model.user.User;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "carrinho")
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Carrinho{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="carrinho_id")
    private Long id;
    @Transient
    private List<CarrinhoObserver> observers = new ArrayList<CarrinhoObserver>();
   
    //@JoinColumn(name = "carrinho_id", insertable = false, updatable = false)
    @OneToMany
    private List<ProdutoCarrinho> produtos;

    public Carrinho(CarrinhoRequestDTO data) {
        this.produtos = data.produtos();
    }
    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    
    public void AtualizarProduto(ProdutoCarrinho produtoCarrinho) {
        this.produtos.add(produtoCarrinho);
    }

    //Observer
    public void registrarObservador(CarrinhoObserver observer) {
        observers.add(observer);
    }

    public void removerObservador(CarrinhoObserver observer) {
        observers.remove(observer);
    }
    private void notificarObservadores() {
        for (CarrinhoObserver observer : observers) {
            observer.atualizar();
        }
    }
    
    public double calculaTotalCarrinho(){
        double total = 0;
        for (ProdutoCarrinho produtoCarrinho : produtos){
            total += produtoCarrinho.getQuantidade() * produtoCarrinho.getProduto().getPreco();
        }
        return total;
    }
}
