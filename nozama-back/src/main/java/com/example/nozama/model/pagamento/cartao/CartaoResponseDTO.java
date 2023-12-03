package com.example.nozama.model.pagamento.cartao;

import com.example.nozama.model.user.User;

public record CartaoResponseDTO(Long id, String titular, String numero,String vencimento, String cvv, String tipo) {
    public CartaoResponseDTO(Cartao cartao) {
        this(cartao.getId(), cartao.getTitular(), cartao.getCvv(), cartao.getNumero(), cartao.getVencimento(), cartao.getTipo());
    }
}