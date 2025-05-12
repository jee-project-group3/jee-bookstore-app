package za.ac.tut.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity class representing an item in an order in the bookstore application.
 */
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // 🔹 No-arg constructor (required by JPA)
    public OrderItem() {
    }

    // 🔹 Full constructor
    public OrderItem(Integer quantity, Book book, Order order) {
        this.quantity = quantity;
        this.book = book;
        this.order = order;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        return (this.id != null || other.id == null) &&
               (this.id == null || this.id.equals(other.id));
    }

    // 🔹 toString
    @Override
    public String toString() {
        return "za.ac.tut.entities.OrderItem[ id=" + id + ", quantity=" + quantity + " ]";
    }
}
