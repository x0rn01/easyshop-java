package be.swo.easyshop.webservice.rest;

import be.swo.easyshop.Item;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/api")
public class UserRESTService {

    @GetMapping(path = "/user", produces = APPLICATION_JSON)
    @ApiOperation("Get User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = String.class)
    })
    @Transactional(readOnly = true)
    public Item getUser() {
        /*checkAuthorized(application, ROLE_LOCATIONS, ROLE_APP_USER);

        Location location = getOrThrowNotFound(locationService.getByUid(application, uid), "Location");
        if (!locationService.hasPermission(application, location, getAuthenticatedUser())) {
            throw new ForbiddenException("user has no permission to the location");
        } */
        //return Response.ok(map(location, LocationDTO.class)).build();
        Item item = new Item();
        item.setId("1");
        item.setName("swou");
        return item;
    }

}
