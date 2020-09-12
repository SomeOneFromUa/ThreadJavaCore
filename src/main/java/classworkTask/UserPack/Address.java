package classworkTask.UserPack;

import java.util.Objects;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    Geo GeoObject;

    public Address() {
    }

    public Address(String street, String suite, String city, String zipcode, Geo geoObject) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        GeoObject = geoObject;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeoObject() {
        return GeoObject;
    }

    public void setGeoObject(Geo geoObject) {
        GeoObject = geoObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                suite.equals(address.suite) &&
                city.equals(address.city) &&
                zipcode.equals(address.zipcode) &&
                GeoObject.equals(address.GeoObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipcode, GeoObject);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", GeoObject=" + GeoObject +
                '}';
    }
}
