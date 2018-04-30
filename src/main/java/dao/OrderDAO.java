package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.Order;
import dao.utils.ConnectionUtils;
import models.Tariff;

public class OrderDAO extends ConnectionUtils
{
    public static List<Order> getOrders() throws SQLException, ClassNotFoundException
    {
        List<Order> orders = new ArrayList();

        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement
                    ("SELECT o.idOrder, o.creatingOrder, o.startExecutionOrder, o.closingOrder, o.cost, o.distance, t.tariffName"
                       +" FROM orders o JOIN tariff t ON o.idTariff = t.idTariff");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Order order = new Order();
                order.setId(rs.getInt("idOrder"));
                order.setCreatingOrder(rs.getTimestamp("creatingOrder"));
                order.setStartExecutionOrder(rs.getTimestamp("startExecutionOrder"));
                order.setClosingOrder(rs.getTimestamp("closingOrder"));
                order.setCost(rs.getInt("cost"));
                order.setDistance(rs.getInt("distance"));
                order.setTariffName(rs.getString("tariffName"));
                orders.add(order);
            }
            closeConnection();
            return orders;
        }
        else
        {
            return null;
        }
    }

    public static Order getOrderById(int id) throws ClassNotFoundException, SQLException
    {
        Order order = new Order();
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement ("SELECT o.idOrder, o.creatingOrder, o.startExecutionOrder, o.closingOrder, o.cost, o.distance, t.tariffName"
                                                                        + " FROM orders o JOIN tariff t ON o.idTariff = t.idTariff"
                                                                        + " WHERE o.idOrder = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    order.setId(rs.getInt("idOrder"));
                    order.setCreatingOrder(rs.getTimestamp("creatingOrder"));
                    order.setStartExecutionOrder(rs.getTimestamp("startExecutionOrder"));
                    order.setClosingOrder(rs.getTimestamp("closingOrder"));
                    order.setCost(rs.getInt("cost"));
                    order.setDistance(rs.getInt("distance"));
                    order.setTariffName(rs.getString("tariffName"));
                }
                closeConnection();
                return order;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    public static void addOrder(Order o) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO orders (creatingOrder, startExecutionOrder, closingOrder, cost, distance, idTariff)"
                                                                        + " VALUES (?,?,?,?,?,?)");
            ps.setTimestamp(1,o.getCreatingOrder());
            ps.setTimestamp(2,o.getStartExecutionOrder());
            ps.setTimestamp(3,o.getClosingOrder());
            ps.setInt(4,o.getCost());
            ps.setInt(5,o.getDistance());
            ps.setInt(6,TariffDAO.getIdTariffByName(o.getTariffName()));
            ps.executeUpdate();
            closeConnection();
        }
    }

    public static void deleteOrderById(int id) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("DELETE FROM orders WHERE idOrder = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            closeConnection();
        }
    }

    public static void editOrder(Order o) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("UPDATE orders SET creatingOrder = ?, startExecutionOrder = ?, closingOrder = ?, cost = ?, distance = ?, idTariff = ? WHERE idOrder = ?");
            ps.setTimestamp(1,o.getCreatingOrder());
            ps.setTimestamp(2,o.getStartExecutionOrder());
            ps.setTimestamp(3,o.getClosingOrder());
            ps.setInt(4,o.getCost());
            ps.setInt(5,o.getDistance());
            ps.setInt(6,TariffDAO.getIdTariffByName(o.getTariffName()));
            ps.setInt(7,o.getId());
            ps.executeUpdate();
            closeConnection();
        }
    }
}
