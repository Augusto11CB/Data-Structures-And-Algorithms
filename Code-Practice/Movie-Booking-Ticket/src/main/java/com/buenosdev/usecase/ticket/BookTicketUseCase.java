package com.buenosdev.usecase.ticket;

import java.util.List;

public interface BookTicketUseCase {
    List<String> bookTicket(int ticketId, int showId, int ticketCount);
}
