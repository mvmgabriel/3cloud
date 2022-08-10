package br.com.trescon.instruments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trescon.instruments.entities.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
