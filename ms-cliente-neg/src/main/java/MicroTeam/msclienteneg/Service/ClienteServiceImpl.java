package MicroTeam.msclienteneg.Service;

import MicroTeam.msclienteneg.Entity.ClienteEntity;
import MicroTeam.msclienteneg.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public String createClienteEntity(ClienteEntity cliente) {
        if (cliente.getEdad()>=25){
          this.clienteRepository.save(cliente);
          return "Cliente inbgresado";
        }else{
            return " no puede ser menor a 25 años";
        }
    }

    @Override
    public ClienteEntity buscarClientePorRut(String rut) {
        return this.clienteRepository.findOneByRut(rut).get();
    }

    @Override
    public List<ClienteEntity> buscarTodos() {

        return this.clienteRepository.findAll();
    }

    @Override
    public void updateClienteEntity(ClienteEntity cliente) {
         this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteClienteEntity(ClienteEntity cliente) {
              this.clienteRepository.deleteAll();
    }


}
