package daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Ticket;

public interface TicketDao {
	Ticket get(Long id);

    void insert(Ticket entity);

    void update(Ticket entity);

    void delete(Long id);

    List<Ticket> getAll();
}
