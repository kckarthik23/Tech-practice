package com.concurrency.Entity;

public class Laptops implements Products {
    private long dfeaultPrice;
    private String name;

    public Laptops(long price, String name) {
        this.dfeaultPrice = price;
        this.name = name;
    }

    public long getPrice() {
        return dfeaultPrice;
    }

    public void setPrice(long price) {
        this.dfeaultPrice = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (dfeaultPrice ^ (dfeaultPrice >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptops other = (Laptops) obj;
        if (dfeaultPrice != other.dfeaultPrice)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public long getDefaultPrice() {
        // TODO Auto-generated method stub
        return this.getPrice();
    }

    @Override
    public String toString() {
        return "Laptops [dfeaultPrice=" + dfeaultPrice + ", name=" + name + "]";
    }

}
