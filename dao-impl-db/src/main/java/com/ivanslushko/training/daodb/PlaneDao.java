package daodb;

import java.util.List;

import com.ivanslushko.training.datamodel.Plane;

public interface PlaneDao {

	Plane get(Long id);

    void insert(Plane entity);

    void update(Plane entity);

    void delete(Long id);

    List<Plane> getAll();
}
