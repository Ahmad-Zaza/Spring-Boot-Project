package com.example.FifthSpringFinal.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "estates")
public class EstateDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private CustomUser customUser;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(name = "num_of_shares", nullable = false)
    private int numOfShares;

    @Column(name = "is_sold")
    @Nullable
    private boolean isSold;

    @Column
    @Nullable
    private String purchaser;

    @Column
    @Nullable
    private double sellPrice;

    @Column(name = "updated_at")
    @LastModifiedDate
    Date updatedAt;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = new Date(System.currentTimeMillis());
    }

    @Column
    public String whoAdd;

    @Column
    public String whoEdit;

    public String getWhoAdd() {
        return whoAdd;
    }

    public void setWhoAdd(String whoAdd) {
        this.whoAdd = whoAdd;
    }

    public String getWhoEdit() {
        return whoEdit;
    }

    public void setWhoEdit(String whoEdit) {
        this.whoEdit = whoEdit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(int numOfShares) {
        this.numOfShares = numOfShares;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "EstateDto{" +
                "id=" + id +
                ", customUser=" + customUser +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numOfShares=" + numOfShares +
                ", isSold=" + isSold +
                ", purchaser='" + purchaser + '\'' +
                ", sellPrice='" + sellPrice + '\'' +
                '}';
    }
}
