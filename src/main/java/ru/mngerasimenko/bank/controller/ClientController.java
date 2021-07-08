package ru.mngerasimenko.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mngerasimenko.bank.domain.Client;
import ru.mngerasimenko.bank.service.ClientService;

import java.util.List;
import java.util.UUID;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String findAllClients(Model model) {
        List<Client> clientList = clientService.findAll();
        model.addAttribute("clients", clientList);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client) {
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("client-delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") UUID id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{clientId}")
    public String updateClientForm(@PathVariable("clientId") UUID clientId, Model model) {
        Client client = clientService.getById(clientId);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

}
