package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private final String departmentId; //not sure but assuming from the instructions that it starts with D and has two digits
    @Setter
    private String departmentName;

    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++); //to make sure it has a D first and followed by two digits
            this.departmentName = Util.toTitleCase(departmentName); //uses the title case method from util package
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * takes a string departmentName and checks the validity of it
     * Requirements: departmentName should only contain letters or space
     *
     * @param departmentName the given string departmentName that needs to be checked
     * @return a boolean value based on the validity of the departmentName
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) { //don't want weird cases
            return false;
        }

        if (departmentName.equals(" ")) { // don't want just a space, we want a real name
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            if (!Character.isLetter(departmentName.charAt(i)) && departmentName.charAt(i) != ' ') {
                return false;
            } //to make sure that the character is not something else than letter or space, only those two
        }

        return true;
    }
}
