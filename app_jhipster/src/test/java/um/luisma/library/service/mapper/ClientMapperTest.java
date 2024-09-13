package um.luisma.library.service.mapper;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import um.luisma.library.domain.Client;
import um.luisma.library.service.dto.ClientDTO;

class ClientMapperTest {

    private ClientMapper clientMapper;

    @BeforeEach
    public void setUp() {
        clientMapper = new ClientMapperImpl();
    }

    @Test
    public void testDtoToEntityMapping() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(1L);
        clientDTO.setFirstName("Martin");
        clientDTO.setLastName("Reyes");
        clientDTO.setEmail("martin@gmail.com");
        clientDTO.setAddress("Mendoza, Argentina");
        clientDTO.setPhone("1234");

        Client client = clientMapper.toEntity(clientDTO);

        assertEquals(clientDTO.getId(), client.getId());
        assertEquals(clientDTO.getFirstName(), client.getFirstName());
        assertEquals(clientDTO.getLastName(), client.getLastName());
        assertEquals(clientDTO.getEmail(), client.getEmail());
        assertEquals(clientDTO.getAddress(), client.getAddress());
        assertEquals(clientDTO.getPhone(), client.getPhone());
    }

    @Test
    public void testEntityToDtoMapping() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Martin");
        client.setLastName("Reyes");
        client.setEmail("martin@gmail.com");
        client.setAddress("Mendoza, Argentina");
        client.setPhone("1234");

        ClientDTO clientDTO = clientMapper.toDto(client);

        assertEquals(client.getId(), clientDTO.getId());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getEmail(), clientDTO.getEmail());
        assertEquals(client.getAddress(), clientDTO.getAddress());
        assertEquals(client.getPhone(), clientDTO.getPhone());
    }

    @Test
    public void testNullDtoToEntityMapping() {
        ClientDTO clientDTO = null;
        Client client = clientMapper.toEntity(clientDTO);
        assertNull(client);
    }
}
