package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.EventVenue;
import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface EventVenueRepository extends JpaRepository<EventVenue, Integer> {

	List<EventVenue> findByeventType(String event_search);
}
