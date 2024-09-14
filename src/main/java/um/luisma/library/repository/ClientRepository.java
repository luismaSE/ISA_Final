package um.luisma.library.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import um.luisma.library.domain.Client;

/**
 * Spring Data JPA repository for the Client entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {}
