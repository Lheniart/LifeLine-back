package fr.epsi.lifelineback.DAE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaeRepository extends JpaRepository<DaeEntity, Integer> {
}
