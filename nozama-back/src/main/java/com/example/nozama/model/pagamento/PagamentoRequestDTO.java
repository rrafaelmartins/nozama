package com.example.nozama.model.pagamento;

import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.user.User;

public record PagamentoRequestDTO(User user, Carrinho carrinho, String strategy){
}
