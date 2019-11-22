package MicroTeam.msclienteneg.Service;

import MicroTeam.msclienteneg.Entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    String createClienteEntity(ClienteEntity cliente);
    Optional<ClienteEntity> buscarClientePorRut(String rut);
    List<ClienteEntity> buscarTodos();
    void updateClienteEntity(ClienteEntity cliente);
    void deleteClientePorRut(String id);
    void deleteClienteEntity(ClienteEntity cliente);
}
