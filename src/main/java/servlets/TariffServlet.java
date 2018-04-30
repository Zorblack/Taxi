package servlets;

import dao.OrderDAO;
import dao.TariffDAO;
import models.Order;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            String forward = "";
            String action = req.getParameter("action");
            if (action != null)
            {
                int orderId;
                if (action.equalsIgnoreCase("delete"))
                {
                    forward = "views/viewOrdersPage.jsp";
                    orderId = Integer.parseInt(req.getParameter("orderId"));
                    OrderDAO.deleteOrderById(orderId);
                    req.setAttribute("orders", OrderDAO.getOrders());
                }
                else if (action.equalsIgnoreCase("edit"))
                {
                    forward = "views/addOrdersPage.jsp";
                    orderId = Integer.parseInt(req.getParameter("orderId"));
                    Order order = OrderDAO.getOrderById(orderId);
                    req.setAttribute("order", order);
                    req.setAttribute("tariffs",TariffDAO.getTariffs());
                }
                else if (action.equalsIgnoreCase("insert"))
                {
                    req.setAttribute("tariffs",TariffDAO.getTariffs());
                    forward = "views/addOrdersPage.jsp";
                }
            }
            else
            {
                req.setAttribute("orders", OrderDAO.getOrders());
                forward = "views/viewOrdersPage.jsp";
            }
            RequestDispatcher view = req.getRequestDispatcher(forward);
            view.forward(req, resp);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            int orderId = Integer.parseInt(req.getParameter("orderId"));
            java.sql.Timestamp creatingOrder = java.sql.Timestamp.valueOf(req.getParameter("creatingOrder"));
            java.sql.Timestamp startExecutionOrder = Timestamp.valueOf(req.getParameter("startExecutionOrder"));
            java.sql.Timestamp closingOrder = java.sql.Timestamp.valueOf(req.getParameter("closingOrder"));
            int distance = Integer.parseInt(req.getParameter("distance"));
            String tariffName = req.getParameter("tariffName");
            int cost = TariffDAO.getCostPerKmByTariffName(tariffName)*distance;
            Order order = OrderDAO.getOrderById(orderId);
            if (order != null)
            {
                order.setCreatingOrder(creatingOrder);
                order.setStartExecutionOrder(startExecutionOrder);
                order.setClosingOrder(closingOrder);
                order.setCost(cost);
                order.setDistance(distance);
                order.setTariffName(tariffName);
                OrderDAO.editOrder(order);
            }
            else
            {
                order = new Order(orderId, creatingOrder, startExecutionOrder, closingOrder, cost, distance, tariffName);
                OrderDAO.addOrder(order);
            }
            req.setAttribute("orders", OrderDAO.getOrders());
            req.getRequestDispatcher("views/viewOrdersPage.jsp").forward(req, resp);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
