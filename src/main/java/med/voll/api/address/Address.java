package med.voll.api.address;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    String street;
    String district;
    String city;
    String numberAd;
    String complement;

    public Address(AddressDTO address) {
        this.street = address.street();
        this.district = address.district();
        this.city = address.city();
        this.numberAd = address.numberAd();
        this.complement = address.complement();
    }

    public Address updateData(AddressDTO address) {
        this.street = address.street();
        this.district = address.district();
        this.city = address.city();
        this.numberAd = address.numberAd();
        this.complement = address.complement();
        return this;

    }
}
