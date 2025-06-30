package com.bankapp.mapper;

import com.bankapp.dto.UserDto;
import com.bankapp.entity.Role;
import com.bankapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapRolesToStrings")
    UserDto toDto(User user);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapStringsToRoles")
    User toEntity(UserDto userDto);

    @Named("mapRolesToStrings")
    default Set<String> mapRolesToStrings(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

    @Named("mapStringsToRoles")
    default Set<Role> mapStringsToRoles(Set<String> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(roleName -> {
                    Role role = new Role();
                    role.setName(roleName);
                    return role;
                })
                .collect(Collectors.toSet());
    }
}
