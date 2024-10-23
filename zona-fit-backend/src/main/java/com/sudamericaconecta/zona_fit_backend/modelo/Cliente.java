package com.sudamericaconecta.zona_fit_backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data //metodos get and setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todos los argumentos
@ToString//metoodo para devolver cada valor de la entidad
@EqualsAndHashCode //metodo para comparaciones
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    private String nombre;
    private String apellido;
    private Integer membresia;

}
