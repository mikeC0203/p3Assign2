/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Development;

/**
 *
 * @author michaelcalbay
 */
public class Person {
    
    private String firstName;
    private String lastName;
    
    Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString()
    {
        return this.getFirstName()+" "+this.getLastName();
    }

    //Get Methods-----------------------------------------
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
