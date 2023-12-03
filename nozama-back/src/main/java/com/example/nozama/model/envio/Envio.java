package com.example.nozama.model.envio;
import java.text.ParseException;

import com.example.nozama.model.EnvioFacade.EnvioFacade;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "envio")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;


    public Envio(String codigo) {
        this.codigo = codigo;
    }


    public String getStatus() throws ParseException {
        return EnvioFacade.statusPedido(this.codigo);
    }
}