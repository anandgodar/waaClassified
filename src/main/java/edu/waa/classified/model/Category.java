package edu.waa.classified.model;

import edu.waa.classified.validator.StringSize;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @StringSize(min = 4, max = 20, message = "{Size.Category.name}")
    private String name;
    @StringSize(min = 4, max = 100, message = "{Size.Category.description}")
    private String description;

    private Integer parentId;
    private Date careateOn;
    private Integer createdBy;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORYPRODUCT", joinColumns = {
            @JoinColumn(name = "categoryId", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "productId", referencedColumnName = "id")})
    private List<Product> products;

    public Category() {

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

	/*public Category(String name, String description, Integer parentId, Date careateOn, Integer createdBy,
            List<Product> products) {
		super();
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.careateOn = careateOn;
		this.createdBy = createdBy;
		this.products = products;
	}*/

}