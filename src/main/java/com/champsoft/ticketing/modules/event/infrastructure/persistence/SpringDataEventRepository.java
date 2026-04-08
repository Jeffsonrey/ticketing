package com.champsoft.ticketing.modules.event.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEventRepository extends JpaRepository<EventJpaEntity, String> {
}