package com.example.nozama.controllers;

import com.example.nozama.model.envio.Envio;
import com.example.nozama.model.envio.EnvioRequestDTO;
import com.example.nozama.model.EnvioFacade.EnvioFacade;
import com.example.nozama.model.EnvioFacade.Rastreio;
import com.example.nozama.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listarTodos() {
        return envioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Envio> obterPorId(@PathVariable Long id) {
        return envioService.obterPorId(id);
    }

    @GetMapping("/{id}/rastrear")
    public Optional<Rastreio> rastrearPorId(@PathVariable Long id) throws ParseException {
        return envioService.rastrearPorId(id);
    }

    @PostMapping()
    public Envio salvar(@RequestBody EnvioRequestDTO data) {
        return envioService.salvar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        envioService.deletar(id);
    }
}