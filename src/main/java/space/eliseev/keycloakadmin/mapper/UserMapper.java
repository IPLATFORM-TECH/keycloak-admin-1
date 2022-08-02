package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import space.eliseev.keycloakadmin.commons.TimeUtils;
import space.eliseev.keycloakadmin.dto.UserDto;
import space.eliseev.keycloakadmin.entity.User;

@Mapper(componentModel = "spring", imports = TimeUtils.class)
public
interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "createdTimestamp", expression = "java(TimeUtils.toLocalDateTime(user.getCreatedTimestamp()))")
    UserDto userToDto(User user);
    @Mapping(target = "createdTimestamp", expression = "java(TimeUtils.toLong(userDto.getCreatedTimestamp()))")
    User dtoToUser(UserDto userDto);
}
