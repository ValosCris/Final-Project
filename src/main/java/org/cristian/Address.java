package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0; //since int cannot be null
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public enum Province { //the ones we determined in class
        AB, MB, ON, QC, SK, BC, NB, NS, PEI, NL
    }

    /**
     * takes a string postalCode and verifies if it meets the requirements
     * Instructions: length of 6, and follows the format CDCDCD, where C is a character and D is digit
     * example of a good postalCode: A1B2C3
     *
     * @param postalCode the given string postalCode that needs to be checked
     * @return a boolean value based on the validity of the given postalCode
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0) { //to see if first position and the one every two positions is a digit -> bad
                if (Character.isDigit(postalCode.charAt(i))) {
                    return false;
                }
            } else { //to see if second position and the one every two positions after is a letter -> bad
                if (Character.isLetter(postalCode.charAt(i))) {
                    return false;
                }
            }
        }

        return true; //if it follows the format CDCDCD, where C is character and D is digit
    }

    //no javadoc since it is a setter
    public void setPostalCode(String postalCode) { //method has to be called in setter to see if valid
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.postalCode = null;
        }
    }
}
