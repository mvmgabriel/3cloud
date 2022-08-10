package br.com.trescon.positions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trescon.positions.entities.Position;
import br.com.trescon.positions.entities.PositionId;

@Repository
public interface PositionRepository extends JpaRepository<Position, PositionId> {

}
