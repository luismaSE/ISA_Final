package um.luisma.library.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import um.luisma.library.domain.Publisher;

/**
 * Spring Data JPA repository for the Publisher entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>, JpaSpecificationExecutor<Publisher> {}
