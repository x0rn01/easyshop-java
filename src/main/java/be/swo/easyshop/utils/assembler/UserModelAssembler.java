package be.swo.easyshop.utils.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.webservice.rest.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public
class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    //  It is based on converting a non-model object (User) into a model-based object (EntityModel<User>).
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user, //
                linkTo(methodOn(UserController.class).one(user.getId().toString())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
}
