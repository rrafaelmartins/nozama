package com.example.nozama.model.envio;
public record EnvioResponseDTO(Long id,String codigo,  String status) {
    public EnvioResponseDTO(Envio envio) {
        this(envio.getId(), envio.getCodigo(), envio.getStatus());
    }
}
