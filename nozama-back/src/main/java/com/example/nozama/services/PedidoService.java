package com.example.nozama.services;

import com.example.nozama.model.EnvioFacade.EnvioFacade;
import com.example.nozama.model.EnvioFacade.Rastreio;
import com.example.nozama.model.envio.Envio;
import com.example.nozama.model.pedido.Pedido;
import com.example.nozama.model.pedido.PedidoRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EnvioService envioService;

    //CRUD
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido salvar(Pedido pedido) {
            return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public String enviarPedido(Long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            Envio envio = envioService.salvar();

            pedido.setEnvio(envio);
            pedidoRepository.save(pedido);
            
            return envio.getCodigo();
        }
        return null;
    }   

    public Long obterIdEnvio(Long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            Envio envio = pedido.getEnvio();
            
            return envio.getId();
        }
        return null;
    }

}
