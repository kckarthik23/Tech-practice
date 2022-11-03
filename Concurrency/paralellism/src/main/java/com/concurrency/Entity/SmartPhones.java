package com.concurrency.Entity;

public class SmartPhones implements Products {
private long defaultPrice;
private String name;
public SmartPhones(long price, String name) {
    this.defaultPrice = price;
    this.name = name;
}
public long getPrice() {
    return defaultPrice;
}
public void setPrice(long price) {
    this.defaultPrice = price;
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
    result = prime * result + (int) (defaultPrice ^ (defaultPrice >>> 32));
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
    SmartPhones other = (SmartPhones) obj;
    if (defaultPrice != other.defaultPrice)
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
    return "SmartPhones [defaultPrice=" + defaultPrice + ", name=" + name + "]";
}
    
}
