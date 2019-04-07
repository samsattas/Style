package model;

public class Employee{
	private String name;
	private int id;
	private String position;
	private int inYear;
	private Service service1;
	private Service service2;
	private Service service3;

	public Employee(String name, int id, String position, int inYear, Service service1, Service service2, Service service3){
		this.name =name;
		this.id = id;
		this.position = position;
		this.inYear =inYear;
		this.service1 = service1;
		this.service2 = service2;
		this.service3 = service3;
	}

//getters & setters
	public String getName(){return name;}
	public int getId(){return id;}
	public String getPosition(){return position;}
	public int getInYear(){return inYear;}
	public Service getService1(){return service1;}
	public Service getService2(){return service2;}
	public Service getService3(){return service3;}

	public void setName(String name){this.name = name;}
	public void setId(int id){this.id = id;}
	public void setPosition(String position){this.position = position;}
	public void setInYear(int inYear){this.inYear = inYear;}
	public void setService1(Service service1){this.service1 = service1;}
	public void setService2(Service service2){this.service2 = service2;}
	public void setService3(Service service3){this.service3 = service3;}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(name);
        sb.append("\nIdentificacion: ");
        sb.append(id);
        sb.append("\nCargo: ");
        sb.append(position);
        sb.append("\nA\u00f1o de entrada: ");
        sb.append(inYear); 
        sb.append("\nServicios:\n");
        sb.append("1)-------------- " + service1 + "\n----------------\n");
        sb.append("2)-------------- " + service2 + "\n----------------\n");
        sb.append("3)-------------- " + service3 + "\n----------------");
        return sb.toString();
    } 


	public void registerService(String type, int timesMade, double earnings, double taxes){
		if (service1 == null) {
			Service serv1 = new Service(type, timesMade, earnings, taxes);
			setService1(serv1);
		}else if (service2 == null&&service1.getType() != type) {
			Service serv2 = new Service(type, timesMade, earnings, taxes);
			setService2(serv2);
		}else if (service3 == null&&service1.getType() != type&&service2.getType() != type) {
			Service serv3 = new Service(type, timesMade, earnings, taxes);
			setService3(serv3);
		}else{
			System.out.println("YA REALIZA TODOS LOS SERVICIOS");
		}
	}

	public void updateService(int num, int select){
		if(select == 1&&service1 != null){
			service1.setTimesMade(service1.getTimesMade() + num);
		}else if(select == 2&&service2 != null){
			service2.setTimesMade(service2.getTimesMade() + num);
		}else if(select == 3&&service3 != null){
			service3.setTimesMade(service3.getTimesMade() + num);
		}else{
			System.out.println("OPCION INVALIDA, INGRESE DE NUEVO");
		}
	}
}