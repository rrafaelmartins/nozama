package com.example.nozama.model.pagamento.cartao;

public record CartaoRequestDTO(String titular, String numero,String vencimento, String cvv) {
}
