package com.example.gym_managment_backend.controllers;

import com.example.gym_managment_backend.models.Client;
import com.example.gym_managment_backend.models.Trainer;
import com.example.gym_managment_backend.models.dto.ClientAndTrainerDto;
import com.example.gym_managment_backend.models.dto.ClientDto;
import com.example.gym_managment_backend.models.enums.Experience;
import com.example.gym_managment_backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientsController {

    private final ClientService clientService;

    @GetMapping()
    public List<Client> getAllClients() {
        return this.clientService.listAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return this.clientService.findClientById(id);
    }

    @GetMapping("/trainer/{id}")
    public Trainer getTrainerByClientId(@PathVariable Long id){
        return this.clientService.findClientById(id).getTrainer();
    }

    @GetMapping("/clientAndTrainer/{id}")
    public ClientAndTrainerDto getClientAndTrainer(@PathVariable Long id){
        Client client = this.clientService.findClientById(id);
        return new ClientAndTrainerDto(client,client.getTrainer());
    }

    @PostMapping("/save")
    public void saveClient(@RequestBody ClientDto clientDto){
        this.clientService.saveClient(clientDto.getName(),clientDto.getSurname(),clientDto.getAddress(),clientDto.getPhone_number(),
                Experience.valueOf(clientDto.getExperience()),clientDto.getTrainerId(),clientDto.getTraining_programId());
    }

    @PutMapping("/edit/{id}")
    public Client editClient(@PathVariable Long id,@RequestBody ClientDto clientDto){
        return this.clientService.editClient(id,clientDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id){
        this.clientService.deleteClient(id);
    }
}
