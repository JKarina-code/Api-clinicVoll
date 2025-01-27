package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDTO;

public record UpdateDoctorDTO(
        @NotNull Long id,
        String name,
        String document,
        AddressDTO address
) {
}
