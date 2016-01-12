package edu.waa.classified.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.waa.classified.validator.Phone;
import edu.waa.classified.validator.StringSize;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /*@Min(5) @Max(15)*/
    @StringSize(message = "{notEmpty.user.userName}")
    //@Unique(message="unique.user.userName")
    private String userName;


    @StringSize(message = "{notEmpty.user.password}")
    private String password;
    private String roleName;

    private String profileImage;


    @StringSize(min = 4, max = 15)
    private String firstName;
    @StringSize
    private String lastName;


    @Email
    private String email;

    /*@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past*/
    private Date dateOfBirth;


    @Phone(message = "{phone.user.phoneNumber}")
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "WISHLIST", joinColumns = {
            @JoinColumn(name = "userId", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "productId", referencedColumnName = "id")})
    @JsonIgnore
    private List<Product> products;

    public User() {

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
