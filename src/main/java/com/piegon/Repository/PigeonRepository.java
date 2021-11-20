package com.piegon.Repository;

import com.piegon.Models.Pigeon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigeonRepository extends JpaRepository<Pigeon, Long> {
}
