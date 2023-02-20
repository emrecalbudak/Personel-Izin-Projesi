package orion.Dayoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orion.Dayoff.entity.DayOff;

public interface DayOffRepository extends JpaRepository<DayOff,Integer> {

}
