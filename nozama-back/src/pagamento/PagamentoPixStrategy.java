public class PagamentoPixStrategy implements PagamentoStrategy{
    void processaPagamento(double valor){
        System.out.println("O valor:" + valor + "foi pago no PIX!");
    }
}
