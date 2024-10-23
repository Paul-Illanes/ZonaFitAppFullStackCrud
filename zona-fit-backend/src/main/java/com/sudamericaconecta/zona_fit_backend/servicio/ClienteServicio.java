package com.sudamericaconecta.zona_fit_backend.servicio;


import com.sudamericaconecta.zona_fit_backend.modelo.Cliente;
import com.sudamericaconecta.zona_fit_backend.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired //autoinyectar una referencia
    private ClienteRepositorio clienteRepositorio;
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();

        return clientes;
    }
    @Override
    public Cliente buscarClientePorId(Integer id_cliente) {
        Cliente cliente = clienteRepositorio.findById(id_cliente).orElse(null);
        return cliente;

    }
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return this.clienteRepositorio.save(cliente);

    }
    @Override
    public void eliminarClientePorId (Integer id_cliente) {
        this.clienteRepositorio.deleteById(id_cliente);

    }
}
