package com.example.nozama.model.pedido;
import com.example.nozama.model.produto.Produto;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    //private EstadoPedido estado;

    //faltam os getters e setters
}

