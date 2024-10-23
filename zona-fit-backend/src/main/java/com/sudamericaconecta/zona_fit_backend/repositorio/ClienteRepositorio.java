package com.sudamericaconecta.zona_fit_backend.repositorio;


import com.sudamericaconecta.zona_fit_backend.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository <Cliente,Integer> {

}
