package med.voll.api.doctor;

public record ListDoctorDTO(Long id, String name, String email, String document, String specialty) {
    public ListDoctorDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getDocument(), doctor.getSpecialty().toString());
    }

}
