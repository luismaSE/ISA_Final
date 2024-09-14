package um.luisma.library.service.mapper;

import org.mapstruct.*;
import um.luisma.library.domain.Publisher;
import um.luisma.library.service.dto.PublisherDTO;

/**
 * Mapper for the entity {@link Publisher} and its DTO {@link PublisherDTO}.
 */
@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherDTO, Publisher> {}
