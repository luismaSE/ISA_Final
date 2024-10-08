package um.luisma.library.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import um.luisma.library.web.rest.TestUtil;

class BorrowedBookDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BorrowedBookDTO.class);
        BorrowedBookDTO borrowedBookDTO1 = new BorrowedBookDTO();
        borrowedBookDTO1.setId(1L);
        BorrowedBookDTO borrowedBookDTO2 = new BorrowedBookDTO();
        assertThat(borrowedBookDTO1).isNotEqualTo(borrowedBookDTO2);
        borrowedBookDTO2.setId(borrowedBookDTO1.getId());
        assertThat(borrowedBookDTO1).isEqualTo(borrowedBookDTO2);
        borrowedBookDTO2.setId(2L);
        assertThat(borrowedBookDTO1).isNotEqualTo(borrowedBookDTO2);
        borrowedBookDTO1.setId(null);
        assertThat(borrowedBookDTO1).isNotEqualTo(borrowedBookDTO2);
    }
}
