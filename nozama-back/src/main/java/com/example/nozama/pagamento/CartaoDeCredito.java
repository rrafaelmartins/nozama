package com.example.nozama.pagamento;

public class CartaoDeCredito {
    private double limite;
    private String numero;
    private String vencimento;
    private String cvv;

    public CartaoDeCredito(double limite, String numero, String vencimento, String cvv) {
        this.limite = limite;
        this.numero = numero;
        this.vencimento = vencimento;
        this.cvv = cvv;
    }

}
