package MicroTeam.msclienteneg.Service;

import MicroTeam.msclienteneg.Entity.ClienteEntity;
import MicroTeam.msclienteneg.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public String createClienteEntity(ClienteEntity cliente) {
        if (cliente.getEdad()>=25){
          this.clienteRepository.save(cliente);
          return "Cliente inngresado";
        }else{
            return " no puede ser menor a 25 años";
        }
    }

     /*@Override
    public String createClienteEntity(ClienteEntity cliente) {
        if(ValidarLicencia( cliente.getFecha_vencimiento(), cliente)) {
            if (cliente.getEdad() >= 25) {
                this.clienteRepository.save(cliente);
                return "Cliente inngresado";
            } else {
                return " no puede ser menor a 25 años";
            }
        } else{
            return "la licencia esta vencida";
        }
    }*/

    @Override
    public Optional<ClienteEntity> buscarClientePorRut(String rut) {
        return this.clienteRepository.findOneByRut(rut);
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
    public void deleteClientePorRut(String rut) {

         this.clienteRepository.deleteById(rut);
    }

    @Override
    public void DeleteAllClienteEntityes() {
         this.clienteRepository.deleteAll();
    }

    /*public String ValidarLicencia(LocalDate vencimiento, ClienteEntity cliente){
        LocalDate now = LocalDate.now();
        LocalDate Vencimiento = cliente.getFecha_vencimiento();
        if(vencimiento.isAfter(now)){
            System.out.println("Licencia aceptada");
            return "Cliente ingresado";
        }else{
            System.out.println("La licencia esta vencida");
            return "La licencia esta vencida";

        }
    } */

}
