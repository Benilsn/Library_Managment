package library_managment.controller;

import library_managment.DTO.ClientDTO;
import library_managment.entitys.Client;
import library_managment.exception.LibraryException;
import library_managment.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository cr;

    public ClientController(ClientRepository cr){
        this.cr = cr;
    }

    @GetMapping("/")
    public List<ClientDTO> findAll(){
        var client = cr.findAll();

        return client.stream()
                .map(ClientDTO::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id){
        var c = cr.findById(id)
                .orElseThrow(() -> new LibraryException("Client not found!"));
        return ClientDTO.converter(c);
    }

    @PostMapping("/")
    public void addClient(@RequestBody ClientDTO cd){
        var client = new Client();
        client.setName(cd.getName());
        client.setPhone(cd.getPhone());
        cr.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cr.findById(id).orElseThrow(()->new LibraryException("Client not found!"));
        cr.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody ClientDTO c){
        var client = cr.findById(id);

        if(client.isPresent()){
            var clientToSave = client.get();
            clientToSave.setName(c.getName());
            clientToSave.setPhone(c.getPhone());
            cr.save(clientToSave);
        }else{
            throw  new LibraryException("Client not found!");
        }
    }

}
