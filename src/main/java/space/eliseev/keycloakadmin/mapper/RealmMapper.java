package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import space.eliseev.keycloakadmin.dto.RealmDto;
import space.eliseev.keycloakadmin.entity.Realm;

@Mapper(componentModel = "spring")
public interface RealmMapper {
    Realm dtoToModel(RealmDto realmDto);
    RealmDto modelToDto(Realm realm);
}
