package ru.mngerasimenko.bank.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mngerasimenko.bank.domain.Client;
import ru.mngerasimenko.bank.exception.DaoException;
import ru.mngerasimenko.bank.service.ClientService;

import java.util.List;
import java.util.UUID;

@SpringComponent
@UIScope
public class ClientEditForm extends VerticalLayout {


    @Autowired
    private ClientService clientService;
    Client clientItem;

    private final Grid<Client> clientGrid;
    private final TextField searchFioField;
    private final TextField searchTelephoneField;

    private final Button deleteClient;
    Dialog popupWindows;


    private List<Client> clientList;

    public ClientEditForm(ClientService clientService) {
        this.clientService = clientService;
        searchFioField = new TextField("Fio");
        searchTelephoneField = new TextField("Telephone");

        clientList = clientService.findAll();
        this.clientGrid = new Grid<>(Client.class);

        initGrid();

        deleteClient = new Button("Delete");
        deleteClient.addClickListener(event -> {
            if (!clientGrid.getSelectedItems().isEmpty()) {
                setClientItem();
                createWindow("Delete client", 3);
            }else Notification.show("Please select a client for delete");
        });




        add(initSearchLayout(), clientGrid, deleteClient);
    }

    private void setClientItem() {
        clientItem = clientGrid.getSelectedItems().iterator().next();
    }

    private void initGrid() {
        clientGrid.setItems(clientList);
        clientGrid.getDataProvider().refreshAll();
    }

    private HorizontalLayout initSearchLayout() {

        searchFioField.setValueChangeMode(ValueChangeMode.EAGER);
        searchFioField.addValueChangeListener(event -> {
            clientList = clientService.findByFioAndTelephone(searchFioField.getValue(),
                    searchTelephoneField.getValue());
            initGrid();
        });

        searchTelephoneField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTelephoneField.addValueChangeListener(event -> {
            clientList = clientService.findByFioAndTelephone(searchFioField.getValue(),
                    searchTelephoneField.getValue());
            initGrid();
        });

        return new HorizontalLayout(new Label("Search"), searchFioField, searchTelephoneField);
    }

    private void createWindow(String winName, int type) {
//        if (type == 3) {
            UUID clientID = clientItem.getClientId();
            String fio = clientItem.getFio();
            Label label = new Label("Delete client " + fio + "?");
            Button okButton = new Button("OK", (event -> {
                try {
                    clientService.deleteClient(clientID);
                    initGrid();
                    Notification.show("City '" + fio + "' was deleted");
                    popupWindows.close();
                } catch (DaoException e) {
                    Notification.show("You can't delete a client! The client has already been issued a credit or an offer.");
                    popupWindows.close();
                }
            }));
            Button cancelButton = new Button("Cancel", (event -> popupWindows.close()));
            popupWindows = new Dialog(new VerticalLayout(label ,new HorizontalLayout(okButton, cancelButton)));

//        } else {
//            popupWindows = new Window(winName, initEditor(type));
//        }
        popupWindows.setModal(true);
        popupWindows.setResizable(false);
        popupWindows.open();
    }
}

