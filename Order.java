package za.ac.tut.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class representing an order in the bookstore application.
 */
@Entity
@Table(name = "orders_table") 
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_date",nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    // 🔹 No-arg constructor (required by JPA)
    public Order() {
        // Default constructor for JPA
    }

    // 🔹 Full constructor
    public Order(LocalDateTime orderDate, AppUser appUser, List<OrderItem> items) {
        this.orderDate = orderDate;
        this.appUser = appUser;
        this.items = items;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // 🔹 hashCode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    // 🔹 equals
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        return (this.id != null || other.id == null) &&
               (this.id == null || this.id.equals(other.id));
    }

    // 🔹 toString
    @Override
    public String toString() {
        return "za.ac.tut.entities.Order[ id=" + id + ", orderDate=" + orderDate + " ]";
    }
}
