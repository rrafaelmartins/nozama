package com.example.nozama.controllers;

import com.example.nozama.model.pedido.Pedido;
import com.example.nozama.model.pedido.PedidoRequestDTO;
import com.example.nozama.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obterPorId(@PathVariable Long id) {
        return pedidoService.obterPorId(id);
    }

    @PostMapping()
    public Pedido salvar(@RequestBody PedidoRequestDTO data) {
        Pedido pedido = new Pedido(data);
        return pedidoService.salvar(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }
}