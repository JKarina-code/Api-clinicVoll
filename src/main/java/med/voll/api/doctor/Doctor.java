package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;

    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public Doctor(RegisterDoctorDTO registerDoctorDTO) {
        this.active = true;
        this.name = registerDoctorDTO.name();
        this.email = registerDoctorDTO.email();
        this.document = registerDoctorDTO.document();
        this.phone = registerDoctorDTO.phone();
        this.specialty = registerDoctorDTO.specialty();
        this.address = new Address(registerDoctorDTO.address());
    }

    public void updateData(UpdateDoctorDTO updateDoctorDTO) {
        if (updateDoctorDTO.name() != null) {
            this.name = updateDoctorDTO.name();
        }
        if (updateDoctorDTO.document() != null) {
            this.document = updateDoctorDTO.document();
        }
        if (updateDoctorDTO.address() != null) {
            this.address = address.updateData(updateDoctorDTO.address());
        }
    }

    public void inactiveDoctor() {
        this.active = false;
    }
}
