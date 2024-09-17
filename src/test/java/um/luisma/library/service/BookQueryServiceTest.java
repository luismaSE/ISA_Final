package um.luisma.library.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import um.luisma.library.domain.Book;
import um.luisma.library.repository.BookRepository;
import um.luisma.library.service.criteria.BookCriteria;
import um.luisma.library.service.dto.BookDTO;
import um.luisma.library.service.mapper.BookMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookQueryServiceTest {

    @InjectMocks
    private BookQueryService bookQueryService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByCriteria() {
        BookCriteria criteria = new BookCriteria();
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        books.add(book);

        List<BookDTO> bookDTOs = new ArrayList<>();
        BookDTO bookDTO = new BookDTO();
        bookDTOs.add(bookDTO);

        when(bookRepository.findAll(any(Specification.class))).thenReturn(books);
        when(bookMapper.toDto(anyList())).thenReturn(bookDTOs);

        List<BookDTO> result = bookQueryService.findByCriteria(criteria);
        
        assertEquals(bookDTOs, result);
        verify(bookRepository, times(1)).findAll(any(Specification.class));
        verify(bookMapper, times(1)).toDto(anyList());
    }


    @Test
    public void testCountByCriteria() {
        BookCriteria criteria = new BookCriteria();
        long count = 5L;

        when(bookRepository.count(any(Specification.class))).thenReturn(count);

        long result = bookQueryService.countByCriteria(criteria);
        
        assertEquals(count, result);
        verify(bookRepository, times(1)).count(any(Specification.class));
    }
}
