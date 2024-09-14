package um.luisma.library.service.mapper;

import org.mapstruct.*;
import um.luisma.library.domain.Author;
import um.luisma.library.service.dto.AuthorDTO;

/**
 * Mapper for the entity {@link Author} and its DTO {@link AuthorDTO}.
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {}
