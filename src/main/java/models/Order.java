package models;

import dao.OrderDAO;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Order {

    private int id;
    private java.sql.Timestamp creatingOrder;
    private java.sql.Timestamp startExecutionOrder;
    private java.sql.Timestamp closingOrder;
    private int cost;
    private int distance;
    private String tariffName;

    public Order() {}

    public Order(int id, java.sql.Timestamp creatingOrder, java.sql.Timestamp startExecutionOrder, java.sql.Timestamp closingOrder, int cost, int distance, String tariffName)
    {
        this.id = id;
        this.creatingOrder = creatingOrder;
        this.startExecutionOrder = startExecutionOrder;
        this.closingOrder = closingOrder;
        this.cost = cost;
        this.distance = distance;
        this.tariffName = tariffName;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public java.sql.Timestamp getCreatingOrder()
    {
        return this.creatingOrder;
    }

    public void setCreatingOrder(java.sql.Timestamp creatingOrder)
    {
        this.creatingOrder = creatingOrder;
    }

    public java.sql.Timestamp getStartExecutionOrder()
    {
        return this.startExecutionOrder;
    }

    public void setStartExecutionOrder(java.sql.Timestamp startExecutionOrder)
    {
        this.startExecutionOrder = startExecutionOrder;
    }

    public java.sql.Timestamp getClosingOrder()
    {
        return this.closingOrder;
    }

    public void setClosingOrder(java.sql.Timestamp closingOrder)
    {
        this.closingOrder = closingOrder;
    }

    public Integer getCost()
    {
        return this.cost;
    }

    public void setCost(Integer cost)
    {
        this.cost = cost;
    }

    public Integer getDistance()
    {
        return this.distance;
    }

    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    public String getTariffName()
    {
        return this.tariffName;
    }

    public void setTariffName(String tariffName)
    {
        this.tariffName = tariffName;
    }

}
