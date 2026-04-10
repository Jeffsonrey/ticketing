package com.champsoft.ticketing.modules.ticketOrderManagement.application.port.out;

import com.champsoft.ticketing.modules.ticketOrderManagement.model.TicketOrder;

import java.util.List;
import java.util.Optional;

public interface TicketOrderRepositoryPort {

    List<TicketOrder> findAll();

    Optional<TicketOrder> findById(Long id);

    TicketOrder save(TicketOrder ticketOrder);

    void delete(TicketOrder ticketOrder);
}