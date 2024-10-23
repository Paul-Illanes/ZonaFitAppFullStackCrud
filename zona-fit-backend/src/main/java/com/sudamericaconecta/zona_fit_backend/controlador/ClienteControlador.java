package com.sudamericaconecta.zona_fit_backend.controlador;
import com.sudamericaconecta.zona_fit_backend.modelo.Cliente;
import com.sudamericaconecta.zona_fit_backend.servicio.IClienteServicio;
import jakarta.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
//localhost:8080/clientela-app
@RequestMapping("clientela-app")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    IClienteServicio clienteServicio;
    private List<Cliente> clientes;


    //http://localhost:8080/clientela-app/clientes
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = this.clienteServicio.listarClientes();
        logger.info("Productos obtenidos");
        clientes.forEach(cliente -> logger.info(cliente.toString()));

    return clientes;
    }
    @PostMapping("/clientes")
    public Cliente agregarCliente(@RequestBody Cliente cliente){
        logger.info("Cliente a agregar " + cliente);
        return this.clienteServicio.guardarCliente(cliente);
    }
    @GetMapping("/clientes/{id_cliente}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id_cliente") int id_cliente) {
        // Lógica para obtener el cliente por ID
        Cliente cliente = this.clienteServicio.buscarClientePorId(id_cliente);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);  // Devuelve el cliente si existe
        } else {
            return ResponseEntity.notFound().build();  // Devuelve 404 si no se encuentra
        }
    }
    @PutMapping("/clientes/{id_cliente}")
    public ResponseEntity<Cliente> actualizarCliente
            (@PathVariable("id_cliente") int id_cliente,
             @RequestBody Cliente clienteRecibido)  {
        // Lógica para obtener el cliente por ID
             Cliente cliente = this.clienteServicio.buscarClientePorId(id_cliente);
             cliente.setNombre(clienteRecibido.getNombre());
             cliente.setApellido(clienteRecibido.getApellido());
             cliente.setMembresia(clienteRecibido.getMembresia());
             this.clienteServicio.guardarCliente(cliente);
             return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/clientes/{id_cliente}")
    public ResponseEntity<Map<String,Boolean>>
            eliminarCliente(@PathVariable("id_cliente") int id_cliente){
            Cliente cliente = clienteServicio.buscarClientePorId(id_cliente);
            this.clienteServicio.eliminarClientePorId(cliente.getId_cliente());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);

    }


}
