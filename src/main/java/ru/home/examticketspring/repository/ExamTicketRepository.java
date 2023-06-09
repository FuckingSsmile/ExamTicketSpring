package ru.home.examticketspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.examticketspring.model.ExamTicket;

@Repository
public interface ExamTicketRepository extends JpaRepository<ExamTicket, Long> {
}
