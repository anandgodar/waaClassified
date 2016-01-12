package edu.waa.classified.model;

import edu.waa.classified.validator.StringSize;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer hitCount;
    @StringSize(min = 4, max = 20)
    private String name;
    @StringSize(min = 4, max = 20)
    private String description;

    private Date careateOn;
    private Integer createdBy;


    private Integer categoryId;

    @Transient
    private MultipartFile fileData;

    private String photoLocation;

    public Product() {

    }

    @Transient
    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCareateOn() {
        return careateOn;
    }

    public void setCareateOn(Date careateOn) {
        this.careateOn = careateOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public String getPhotoLocation() {
        return photoLocation;
    }


    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

	/*
     * public Product(String name, String description, Date careateOn, Integer
	 * createdBy) { super(); this.name = name; this.description = description;
	 * this.careateOn = careateOn; this.createdBy = createdBy;
	 * 
	 * }
	 */

}
