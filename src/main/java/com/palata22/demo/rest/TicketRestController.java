package com.palata22.demo.rest;

import com.palata22.demo.model.Ticket;
import com.palata22.demo.repository.TicketReporsitory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/tickets")
@AllArgsConstructor
public class TicketRestController {

    private final TicketReporsitory ticketReporsitory;

    @GetMapping
    public List<Ticket> getTickets() {
        return ticketReporsitory.findAll();
    }
}
