package dao;

import dao.utils.ConnectionUtils;
import models.Order;
import models.Tariff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TariffDAO extends ConnectionUtils
{
    public static List<Tariff> getTariffs() throws SQLException, ClassNotFoundException
    {
        List<Tariff> tariffs = new ArrayList();

        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("SELECT t.idTariff, t.tariffName, t.costPerKm FROM tariff t");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Tariff tariff = new Tariff();
                tariff.setId(rs.getInt("idTariff"));
                tariff.setTariffName(rs.getString("tariffName"));
                tariff.setCostPerKm(rs.getInt("costPerKm"));
                tariffs.add(tariff);
            }
            closeConnection();
            return tariffs;
        }
        else
        {
            return null;
        }
    }

    public static Tariff getTariffById(int id) throws ClassNotFoundException, SQLException
    {
        Tariff tariff = new Tariff();
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement ("SELECT t.idTariff, t.tariffName, t.costPerKm"
                    + " FROM tariff t"
                    + " WHERE t.idTariff = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    tariff.setId(rs.getInt("idTariff"));
                    tariff.setTariffName(rs.getString("tariffName"));
                    tariff.setCostPerKm(rs.getInt("costPerKm"));
                }
                closeConnection();
                return tariff;
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

    public static void addTariff(Tariff t) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO tariff (tariffName, costPerKm)"
                    + " VALUES (?,?)");
            ps.setString(1,t.getTariffName());
            ps.setInt(2,t.getCostPerKm());
            ps.executeUpdate();
            closeConnection();
        }
    }

    public static void deleteTariffById(int id) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("DELETE FROM tariff WHERE idTariff = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            closeConnection();
        }
    }

    public static void editTariff(Tariff t) throws ClassNotFoundException, SQLException
    {
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("UPDATE tariff SET tariffName = ?, costPerKm = ? WHERE idTariff = ?");
            ps.setString(1,t.getTariffName());
            ps.setInt(2,t.getCostPerKm());
            ps.setInt(3,t.getId());
            ps.executeUpdate();
            closeConnection();
        }
    }

    public static int getIdTariffByName (String tariffName) throws ClassNotFoundException, SQLException
    {
        int id = 0;
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("SELECT t.idTariff FROM tariff t WHERE t.tariffName = ?");
            ps.setString(1,tariffName);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                id = rs.getInt("idTariff");
            }
            closeConnection();
            return id;
        }
        else
        {
            return -1;
        }
    }

    public static int getCostPerKmByTariffName(String tariffName) throws ClassNotFoundException, SQLException
    {
        int cost = 0;
        if (createConnection())
        {
            PreparedStatement ps = getConnection().prepareStatement("SELECT t.costPerKm FROM tariff t WHERE t.tariffName = ?");
            ps.setString(1,tariffName);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                cost = rs.getInt("costPerKm");
            }
            closeConnection();
            return cost;
        }
        else
        {
            return 0;
        }
    }
}
