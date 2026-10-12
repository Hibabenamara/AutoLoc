package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.service.interfaces.IClientService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Set<Client> retrieveAllClients() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).get();
    }

    @Override
    public Client modifyClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}