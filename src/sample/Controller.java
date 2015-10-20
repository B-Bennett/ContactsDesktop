package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


        ObservableList<Contact> contacts = FXCollections.observableArrayList();

        @FXML
        ListView listView;
        @FXML
        TextField textName;
        @FXML
        TextField textPhone;
        @FXML
        TextField textEmail;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            listView.setItems(contacts);
        }

        public void addContact() {
            Contact contact = new Contact(textName.getText(), textPhone.getText(), textEmail.getText());
            if (textName.getText().isEmpty() || textPhone.getText().isEmpty() || textEmail.getText().isEmpty()) {
                return;
            }
            contacts.add(contact);
            textName.setText("");// clears text box after you enter a name.
            textPhone.setText("");
            textEmail.setText("");
        }
        public void removeContact() {
            Contact contact = (Contact) listView.getSelectionModel().getSelectedItem();
            contacts.remove(contact);

        }

}
