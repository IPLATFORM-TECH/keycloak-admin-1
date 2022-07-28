package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import space.eliseev.keycloakadmin.dto.RoleDto;
import space.eliseev.keycloakadmin.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto modelToDto(Role role);

    Role dtoToModel(RoleDto roleDto);
}
