package ru.mngerasimenko.bank.view;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mngerasimenko.bank.service.ClientService;


@Route
public class MainView extends VerticalLayout {

    @Autowired
    private ClientService clientService;
    private ClientEditForm clientEdit;

    public MainView(ClientService clientService, ClientEditForm clientEdit) {

        this.clientService = clientService;
        this.clientEdit = clientEdit;

        add(clientEdit);
    }


}

