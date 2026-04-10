package com.champsoft.ticketing.modules.ticketOrderManagement.persistence;

import com.champsoft.ticketing.modules.ticketOrderManagement.application.port.out.TicketOrderRepositoryPort;
import com.champsoft.ticketing.modules.ticketOrderManagement.model.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>, TicketOrderRepositoryPort {
}