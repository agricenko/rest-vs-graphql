package com.palata22.demo.graphql.ticket;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.palata22.demo.model.Project;
import com.palata22.demo.model.Ticket;
import com.palata22.demo.model.User;
import com.palata22.demo.repository.ProjectRepository;
import com.palata22.demo.repository.TicketReporsitory;
import com.palata22.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketMutation implements GraphQLMutationResolver {

    private final TicketReporsitory ticketReporsitory;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public Ticket newTicket(String description, Long projectId, Long reporterUserId, Long assigneeUserId) {
        User assigneeUser = userRepository.findById(assigneeUserId).get();
        User reporterUser = userRepository.findById(reporterUserId).get();

        Project project = projectRepository.findById(projectId).get();

        Ticket ticket = Ticket.builder().description(description)
                .assigneeUser(assigneeUser)
                .reporterUser(reporterUser)
                .project(project).build();

        ticketReporsitory.save(ticket);

        return ticket;
    }
}
