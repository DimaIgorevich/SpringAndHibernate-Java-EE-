package com.datacentre.model.pojo;
// Generated 17.09.2016 21:33:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * RegistrationCard generated by hbm2java
 */
@Entity
@Table(name="registration_card"
    ,catalog="medicalDB"
)

public class RegistrationCard  implements java.io.Serializable {
    
    @Size(min = 6, max = 10)
    private String mobile;
   
    @NotEmpty
    private String fullName;
    
    @NotNull @Min(0) @Max(150)
    private int age;
    
    @NotNull
    private Date dateRegistration;

    public RegistrationCard() {
    }

    public static void validate(Object object, Validator validator) throws ValidationException{
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        
        if(constraintViolations.size() > 0){
            throw new ValidationException();
        }
    }
    
    public RegistrationCard(String mobile, String fullName, int age, Date dateRegistration) {
       this.mobile = mobile;
       this.fullName = fullName;
       this.age = age;
       this.dateRegistration = dateRegistration;
    }
   
     @Id 
    @Column(name="mobile", unique=true, nullable=false, length=10)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name="full_name", nullable=false, length=100)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="age", nullable=false)
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_registration", nullable=false, length=19)
    public Date getDateRegistration() {
        return this.dateRegistration;
    }
    
    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

}


