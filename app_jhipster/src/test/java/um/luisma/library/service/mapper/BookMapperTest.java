package um.luisma.library.service.mapper;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import um.luisma.library.domain.Book;
import um.luisma.library.service.dto.BookDTO;

class BookMapperTest {

    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        bookMapper = new BookMapperImpl();
    }

    @Test
    public void testDtoToEntityMapping() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setIsbn("1234");
        bookDTO.setName("El Principito");
        bookDTO.setPublishYear("1943");
        bookDTO.setCopies(5);

        Book book = bookMapper.toEntity(bookDTO);

        assertEquals(book.getId(), bookDTO.getId());
        assertEquals(book.getIsbn(), bookDTO.getIsbn());
        assertEquals(book.getName(), bookDTO.getName());
        assertEquals(book.getPublishYear(), bookDTO.getPublishYear());
        assertEquals(book.getCopies(), bookDTO.getCopies());
    }

    @Test
    public void testEntityToDtoMapping() {
        Book book = new Book();
        book.setId(1L);
        book.setIsbn("1234");
        book.setName("El Principito");
        book.setPublishYear("1943");
        book.setCopies(5);

        BookDTO bookDTO = bookMapper.toDto(book);

        assertEquals(book.getId(), bookDTO.getId());
        assertEquals(book.getIsbn(), bookDTO.getIsbn());
        assertEquals(book.getName(), bookDTO.getName());
        assertEquals(book.getPublishYear(), bookDTO.getPublishYear());
        assertEquals(book.getCopies(), bookDTO.getCopies());
    }

    @Test
    public void testNullDtoToEntityMapping() {
        BookDTO bookDTO = null;
        Book book = bookMapper.toEntity(bookDTO);
        assertNull(book);
    }
}