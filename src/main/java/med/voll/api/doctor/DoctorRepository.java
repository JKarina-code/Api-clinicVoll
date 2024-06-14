package med.voll.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findByActiveTrue(Pageable pagination);
}
