package um.luisma.library.service.mapper;

import org.mapstruct.*;
import um.luisma.library.domain.Book;
import um.luisma.library.domain.BorrowedBook;
import um.luisma.library.domain.Client;
import um.luisma.library.service.dto.BookDTO;
import um.luisma.library.service.dto.BorrowedBookDTO;
import um.luisma.library.service.dto.ClientDTO;

/**
 * Mapper for the entity {@link BorrowedBook} and its DTO {@link BorrowedBookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BorrowedBookMapper extends EntityMapper<BorrowedBookDTO, BorrowedBook> {
    @Mapping(target = "book", source = "book", qualifiedByName = "bookName")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEmail")
    BorrowedBookDTO toDto(BorrowedBook s);

    @Named("bookName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    BookDTO toDtoBookName(Book book);

    @Named("clientEmail")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    ClientDTO toDtoClientEmail(Client client);
}
