package model;

public class Service{
	private String type;
	private int timesMade;
	private double earnings;
	private double taxes;

	public Service(String type, int timesMade, double earnings, double taxes){
		this.type = type;
		this.timesMade = timesMade;
		this.earnings = earnings;
		this.taxes = taxes;
	}

//getters & setters
	public String getType(){return type;}
	public int getTimesMade(){return timesMade;}
	public double getEarnings(){return earnings;}
	public double getTaxes(){return taxes;}

	public void setType(String type){this.type = type;}
	public void setTimesMade(int timesMade){this.timesMade = timesMade;}
	public void setEarnings(double earnings){this.earnings = earnings;}
	public void setTaxes(double taxes){this.taxes = taxes;}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTipo de servicio: ");
        sb.append(type);
        sb.append("\nNumero de veces realizado: ");
        sb.append(timesMade);
        sb.append("\nGanancias: ");
        sb.append(earnings);
        sb.append("\nImpuestos: ");
        sb.append(taxes); 
        return sb.toString();
    }
}