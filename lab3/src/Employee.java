/**
 * 08-722 Data Structures for Application Programmers.
 * Lab 3 Simple Sorting and Stability
 *
 * Comparison of Selection sort and Insertion sort Employee class
 * @author Terry Lee
 */
public class Employee {
    /**
     * first name field.
     */
    private String firstName;
    /**
     * last name field.
     */
    private String lastName;
    /**
     * zip code field.
     */
    private int zipCode;

    /**
     * Constructor with parameters.
     * @param firstName first name of employee
     * @param lastName last name of employee
     * @param zipCode zip code of employee
     */
    public Employee(String firstName, String lastName, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    /**
     * Returns last name of employee.
     * @return string value of last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns zip code of employee.
     * @return string value of zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Returns string representation of employee.
     * @return String value of employee
     */
    public String toString() {
        return lastName + ", " + firstName + ", " + zipCode;
    }

}
