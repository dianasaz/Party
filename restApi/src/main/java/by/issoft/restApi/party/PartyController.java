package by.issoft.restApi.party;

import by.issoft.exception.NoEntityException;
import by.issoft.restModel.PartyResponse;
import by.issoft.restModel.ProductResponse;
import by.issoft.restModel.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/parties")
public interface PartyController {
    @GetMapping(value = "/all")
    List<PartyResponse> allParties();

    @GetMapping(value = "/by-address")
    List<PartyResponse> allPartiesByAddress(@RequestBody String address);

    @GetMapping(value = "/{id}")
    PartyResponse  getById(@PathVariable Integer id) throws NoEntityException;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void update(@PathVariable Integer id, @RequestBody PartyResponse partyResponse);

    @GetMapping(value = "/{id}/products")
    List<ProductResponse> allProductsForParty(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/{party_id}/products/{product_id}")
    Integer findCountOfProductOnParty(@PathVariable(value = "party_id") Integer partyId, @PathVariable(value = "product_id") Integer productId);

    @PostMapping(value = "/{party_id}/add/product/{product_id}")
    void addProductForParty(@PathVariable(value = "party_id") PartyResponse partyResponse, @PathVariable(value = "product_id") ProductResponse productResponse);

    @DeleteMapping(value = "/{party_id}/delete/product/{product_id}")
    void deleteProductForParty(@PathVariable(value = "party_id") PartyResponse partyResponse, @PathVariable(value = "product_id") ProductResponse productResponse);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable Integer id);

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    PartyResponse addNew(@RequestBody PartyResponse partyResponse);

    @PostMapping(value = "/{party_id}/add/user/{user_id}")
    void addUserToParty(@PathVariable(value = "party_id") PartyResponse partyResponse, @PathVariable(value = "user_id") UserResponse userInfoResponse);

    @GetMapping(value = "/{party_id}/users")
    List<UserResponse> getAllUsersOnTHisParty(@PathVariable(value = "party_id") Integer id) throws NoEntityException;
}
