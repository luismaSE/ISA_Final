package um.luisma.library.service.mapper;

import org.mapstruct.*;
import um.luisma.library.domain.Client;
import um.luisma.library.service.dto.ClientDTO;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {}
