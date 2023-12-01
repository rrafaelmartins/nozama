package com.example.nozama.model.envio;
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
    private String status;

    public Envio(EnvioRequestDTO data) {
        this.codigo = data.codigo();
        this.status = data.status();
    }

    public Envio(String codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }

}