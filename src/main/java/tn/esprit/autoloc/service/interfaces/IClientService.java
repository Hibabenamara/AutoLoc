package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Client;

import java.util.Set;

public interface IClientService {

    Client addClient(Client client);
    Set<Client> retrieveAllClients();
    Client retrieveClient(Long idClient);
    Client modifyClient(Client client);
    void removeClient(Long idClient);
}
