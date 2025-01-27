package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String district,
        @NotBlank
        String city,
        @NotBlank
        String numberAd,
        @NotBlank
        String complement
) {
}
