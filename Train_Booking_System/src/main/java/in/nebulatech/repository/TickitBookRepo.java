package in.nebulatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import in.nebulatech.bindings.Booking;


public interface TickitBookRepo extends JpaRepository<Booking, String>{

}
