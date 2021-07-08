package ru.mngerasimenko.bank.view;



import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mngerasimenko.bank.domain.Client;
import ru.mngerasimenko.bank.service.ClientService;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private ClientService clientService;

    final Grid<Client> grid;

    public MainView(ClientService clientService) {
        this.clientService = clientService;
        this.grid = new Grid<>(Client.class);
        add(grid);
        listCustomers();
    }

    private void listCustomers() {
        grid.setItems(clientService.findAll());
    }
}

