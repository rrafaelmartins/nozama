package com.example.nozama.model.pagamento.cartao;

import com.example.nozama.model.user.User;

public record CartaoRequestDTO(String titular, String numero,String vencimento, String cvv, String tipo, Long userId) {
}
