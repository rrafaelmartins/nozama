package com.example.nozama.services;

import com.example.nozama.model.pagamento.cartao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;
    public List<Cartao> listarTodos() {
        return cartaoRepository.findAll();
    }
    public Optional<Cartao> obterPorId(Long id) {
        return cartaoRepository.findById(id);
    }
    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }
    public void deletar(Long id) {
        cartaoRepository.deleteById(id);
    }
}
