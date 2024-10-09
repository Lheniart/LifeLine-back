package fr.epsi.lifelineback.DAE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DaeRepository extends JpaRepository<DaeEntity, Integer> {

    @Query("SELECT d FROM DaeEntity d WHERE " +
            "6371 * acos(cos(radians(:latitude)) * cos(radians(d.latitude)) * " +
            "cos(radians(d.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(d.latitude))) <= :distance")
    List<DaeEntity> findNearbyDaes(BigDecimal latitude, BigDecimal longitude, BigDecimal distance);
}
