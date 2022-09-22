package com.example.gym_managment_backend.service;

import com.example.gym_managment_backend.models.Client;
import com.example.gym_managment_backend.models.Trainer;
import com.example.gym_managment_backend.models.Training_program;
import com.example.gym_managment_backend.models.dto.ClientDto;
import com.example.gym_managment_backend.models.enums.Experience;
import com.example.gym_managment_backend.repository.ClientRepo;
import com.example.gym_managment_backend.repository.TrainerRepo;
import com.example.gym_managment_backend.repository.Training_programRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final TrainerRepo trainerRepo;

    private final Training_programRepo training_programRepo;

    public List<Client> listAllClients() {
        return this.clientRepo.findAll();
    }

    public void saveClient(String name, String surname, String address, String phone_number, Experience experience, Long trainerId, Long training_programId) {
        Trainer trainer = this.trainerRepo.findById(trainerId).get();
        Training_program training_program = this.training_programRepo.findById(training_programId).get();
        Client client = new Client(name, surname, address, phone_number, experience, trainer, training_program);
        trainer.getClients().add(this.clientRepo.save(client));
    }

    public Client editClient(Long id, ClientDto clientDto) {
        Client client = clientRepo.findById(id).get();
        Trainer trainer = trainerRepo.findById(clientDto.getTrainerId()).get();
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setAddress(clientDto.getAddress());
        client.setPhone_number(clientDto.getPhone_number());
        client.setTrainer(trainer);
        return clientRepo.save(client);
    }

    public Client findClientById(Long clientId) {
        return this.clientRepo.findById(clientId).get();
    }

    public void deleteClient(Long id) {
        this.clientRepo.deleteById(id);
    }

}
