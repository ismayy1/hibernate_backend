package h2_embeddable;

import javax.persistence.Embeddable;

@Embeddable // new table won't be created, but fields inside this class can be used as columns of embedded
public class Address {

    private String street;
    private String city;
    private String country;
    private String zipCode;

    // getters setters
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
