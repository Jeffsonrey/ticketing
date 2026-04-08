package com.champsoft.ticketing.modules.ticketInventory.persistence;

import com.champsoft.ticketing.modules.ticketInventory.application.port.out.TicketInventoryRepositoryPort;
import com.champsoft.ticketing.modules.ticketInventory.model.TicketInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketInventoryRepository extends JpaRepository<TicketInventory, Long>, TicketInventoryRepositoryPort {
}