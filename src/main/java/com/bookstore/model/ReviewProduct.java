package com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ReviewProduct {

    @EmbeddedId
    @JsonIgnore
    private ReviewProductPK pk;


    public ReviewProduct() {
        super();
    }

    public ReviewProduct(Product product, Customer customer, Review review) {
        pk = new ReviewProductPK();
        pk.setProduct(product);
        pk.setCustomer(customer);
        pk.setReview(review);
    }


    @Transient
    public Customer getCustomer() {
        return this.pk.getCustomer();
    }

    public ReviewProductPK getPk() {
        return pk;
    }

    public void setPk(ReviewProductPK pk) {
        this.pk = pk;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ReviewProduct other = (ReviewProduct) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}
