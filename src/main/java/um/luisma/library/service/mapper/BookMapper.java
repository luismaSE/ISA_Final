package um.luisma.library.service.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;
import um.luisma.library.domain.Author;
import um.luisma.library.domain.Book;
import um.luisma.library.domain.Publisher;
import um.luisma.library.service.dto.AuthorDTO;
import um.luisma.library.service.dto.BookDTO;
import um.luisma.library.service.dto.PublisherDTO;

/**
 * Mapper for the entity {@link Book} and its DTO {@link BookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDTO, Book> {
    @Mapping(target = "publisher", source = "publisher", qualifiedByName = "publisherName")
    @Mapping(target = "authors", source = "authors", qualifiedByName = "authorFirstNameSet")
    BookDTO toDto(Book s);

    @Mapping(target = "removeAuthor", ignore = true)
    Book toEntity(BookDTO bookDTO);

    @Named("publisherName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    PublisherDTO toDtoPublisherName(Publisher publisher);

    @Named("authorFirstName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    AuthorDTO toDtoAuthorFirstName(Author author);

    @Named("authorFirstNameSet")
    default Set<AuthorDTO> toDtoAuthorFirstNameSet(Set<Author> author) {
        return author.stream().map(this::toDtoAuthorFirstName).collect(Collectors.toSet());
    }
}
