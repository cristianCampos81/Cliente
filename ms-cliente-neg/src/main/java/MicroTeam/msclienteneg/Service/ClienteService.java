package MicroTeam.msclienteneg.Service;

import MicroTeam.msclienteneg.Entity.ClienteEntity;

import java.util.List;

public interface ClienteService {

    String createClienteEntity(ClienteEntity cliente);
    ClienteEntity buscarClientePorRut(String rut);
    List<ClienteEntity> buscarTodos();
    void updateClienteEntity(ClienteEntity cliente);
    void deleteClienteEntity(ClienteEntity cliente);
}
