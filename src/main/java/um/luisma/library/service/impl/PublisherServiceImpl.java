package um.luisma.library.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import um.luisma.library.domain.Publisher;
import um.luisma.library.repository.PublisherRepository;
import um.luisma.library.service.PublisherService;
import um.luisma.library.service.dto.PublisherDTO;
import um.luisma.library.service.mapper.PublisherMapper;

/**
 * Service Implementation for managing {@link Publisher}.
 */
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);

    private final PublisherRepository publisherRepository;

    private final PublisherMapper publisherMapper;

    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public PublisherDTO save(PublisherDTO publisherDTO) {
        log.debug("Request to save Publisher : {}", publisherDTO);
        Publisher publisher = publisherMapper.toEntity(publisherDTO);
        publisher = publisherRepository.save(publisher);
        return publisherMapper.toDto(publisher);
    }

    @Override
    public PublisherDTO update(PublisherDTO publisherDTO) {
        log.debug("Request to update Publisher : {}", publisherDTO);
        Publisher publisher = publisherMapper.toEntity(publisherDTO);
        publisher = publisherRepository.save(publisher);
        return publisherMapper.toDto(publisher);
    }

    @Override
    public Optional<PublisherDTO> partialUpdate(PublisherDTO publisherDTO) {
        log.debug("Request to partially update Publisher : {}", publisherDTO);

        return publisherRepository
            .findById(publisherDTO.getId())
            .map(existingPublisher -> {
                publisherMapper.partialUpdate(existingPublisher, publisherDTO);

                return existingPublisher;
            })
            .map(publisherRepository::save)
            .map(publisherMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PublisherDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Publishers");
        return publisherRepository.findAll(pageable).map(publisherMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PublisherDTO> findOne(Long id) {
        log.debug("Request to get Publisher : {}", id);
        return publisherRepository.findById(id).map(publisherMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Publisher : {}", id);
        publisherRepository.deleteById(id);
    }
}
