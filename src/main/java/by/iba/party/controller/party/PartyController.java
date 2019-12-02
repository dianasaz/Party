package by.iba.party.controller.party;

import by.iba.party.entity.Party;
import by.iba.party.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/parties/")
public class PartyController {
    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping(value = "/all")
    public List<Party> allParties() {
        return partyService.findAll();
    }

    @GetMapping (value = "/by-address")
    public List<Party> allPartiesByAddress(@RequestBody String address){
        return partyService.findAllByAddressContains(address);
    }

    @GetMapping(value = "/{id}")
    public Party getById(@PathVariable Integer id) {
        return partyService.findById(id).orElse(new Party());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody Party party) {
        party.setId(id);
        partyService.save(party);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        partyService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addNew(@RequestBody Party party) {
        partyService.save(party);
    }

}
