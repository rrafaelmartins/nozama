package com.example.nozama.model.pagamento.cartao;
public record CartaoResponseDTO(Long id, String titular, String numero,String vencimento, String cvv) {
    public CartaoResponseDTO(Cartao cartao) {
        this(cartao.getId(), cartao.getTitular(), cartao.getCvv(), cartao.getNumero(), cartao.getVencimento());
    }
}