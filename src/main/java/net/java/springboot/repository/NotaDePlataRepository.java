package net.java.springboot.repository;

import net.java.springboot.model.NotaDePlata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaDePlataRepository extends JpaRepository<NotaDePlata, Long> {
}
