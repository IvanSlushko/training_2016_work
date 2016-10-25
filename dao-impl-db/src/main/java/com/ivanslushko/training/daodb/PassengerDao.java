package daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Passenger;

public interface PassengerDao {
	Passenger get(Long id);

    void insert(Passenger entity);

    void update(Passenger entity);

    void delete(Long id);

    List<Passenger> getAll();
}
