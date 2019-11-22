package MicroTeam.msclienteneg.Controller;

import MicroTeam.msclienteneg.Entity.ClienteEntity;
import MicroTeam.msclienteneg.Service.ClienteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(value = {})
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/getByRut")
    public ResponseEntity<?> obtenerClientePorRut(@RequestParam String rut) {
        ResponseEntity<?> response;
        try {
            ClienteEntity cliente = this.clienteService.buscarClientePorRut(rut);
            response = new ResponseEntity<>(cliente, HttpStatus.OK);

        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
     @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        ResponseEntity<?>response;
        try{
            List<ClienteEntity> cliente = this.clienteService.buscarTodos();
            response = new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex);
            response = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping("/addCliente")
    public ResponseEntity<?>addCliente(@RequestBody ClienteEntity cliente){
        ResponseEntity<?> response;
        String respuService = this.clienteService.createClienteEntity(cliente);
        try{
           if (respuService.equals("ok")){
               response = new ResponseEntity<>("{\"Mensaje\":\"Cliente creado exitosamente\"}", HttpStatus.CREATED);
           }else{
               response = new ResponseEntity<>("{\"Error\":\"El Cliente no puede tener menos de 25 años\"}",HttpStatus.BAD_REQUEST);
           }

            } catch (Exception ex){
            response = new ResponseEntity<>("{\"Error\":\"Hubo un problema\"}",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }



}
