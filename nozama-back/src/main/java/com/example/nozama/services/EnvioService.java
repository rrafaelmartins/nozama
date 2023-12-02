package com.example.nozama.services;

import com.example.nozama.model.envio.Envio;
import com.example.nozama.model.envio.EnvioRepository;
import com.example.nozama.model.EnvioFacade.EnvioFacade;
import com.example.nozama.model.EnvioFacade.Rastreio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;
    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }
    public Optional<Envio> obterPorId(Long id) {
        return envioRepository.findById(id);
    }
    public Optional<Rastreio> rastrearPorId(Long id) throws ParseException {
        Optional<Envio> envioOptional = envioRepository.findById(id);

        if (envioOptional.isPresent()){
            Envio envio = envioOptional.get();
            Rastreio rastreio =  EnvioFacade.rastrearPedido(envio.getCodigo());
            return Optional.of(rastreio);
        }
        return Optional.empty();
    }

    public Envio salvar() {
        Envio envio = EnvioFacade.enviarPedido();
        return envioRepository.save(envio);
    }

    public void deletar(Long id) {
        envioRepository.deleteById(id);
    }
}
