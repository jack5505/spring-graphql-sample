package com.graphql.graphql.graphql;

import com.graphql.graphql.entity.UserEntity;
import com.graphql.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.server.GraphQlRSocketHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Controller
@RequiredArgsConstructor
public class UserQueryResolver  {

    private final UserRepository userRepository;

    @MutationMapping
    public UserEntity createUser(@Argument String name,@Argument String email){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @QueryMapping
    public UserEntity getUser(@Argument Long id){
        return userRepository.findById(id).orElse(null);
    }


}
