package net.java.springboot.repository;

import net.java.springboot.model.Bauturi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BauturiRepository extends JpaRepository<Bauturi , Long> {
}
