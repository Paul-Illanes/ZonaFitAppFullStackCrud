package com.sudamericaconecta.zona_fit_backend.servicio;



import com.sudamericaconecta.zona_fit_backend.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer id_cliente);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarClientePorId(Integer id_cliente);
}
