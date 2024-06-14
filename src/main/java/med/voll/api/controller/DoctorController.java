package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO) {
        doctorRepository.save(new Doctor(registerDoctorDTO));
    }

    @GetMapping
    public Page<ListDoctorDTO> listDoctors(@PageableDefault(size = 3) Pageable pagination) {
        return doctorRepository.findByActiveTrue(pagination).map(ListDoctorDTO::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid UpdateDoctorDTO updateDoctorDTO) {
        Doctor doctor = doctorRepository.getReferenceById(updateDoctorDTO.id());
        doctor.updateData(updateDoctorDTO);
    }

    //Inactive Doctor
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.inactiveDoctor();
    }

}
