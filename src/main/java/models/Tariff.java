package models;

public class Tariff
{

    private int id;
    private String tariffName;
    private int costPerKm;

    public Tariff(){}

    public Tariff(int id, String tariffName, int costPerKm)
    {
        this.id = id;
        this.tariffName = tariffName;
        this.costPerKm = costPerKm;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTariffName() {
        return this.tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public int getCostPerKm() {
        return this.costPerKm;
    }

    public void setCostPerKm(int costPerKm) {
        this.costPerKm = costPerKm;
    }
}
