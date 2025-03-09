package delatorre.jestopher.auth_activity.controller;

import delatorre.jestopher.auth_activity.service.GoogleContactsService;
import com.google.api.services.people.v1.model.Person;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    private final GoogleContactsService googlePeopleService;

    public ContactsController(GoogleContactsService googlePeopleService) {
        this.googlePeopleService = googlePeopleService;
    }

    @GetMapping
    public List<Person> getContacts() throws IOException {
        List<Person> contacts = googlePeopleService.getContacts();
        System.out.println("Fetched Contacts: " + contacts);
        return contacts;
    }
}