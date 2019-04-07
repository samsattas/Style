package model;

public class Place{
	public Employee emp1;
	public Employee emp2;

	public Place(Employee emp1, Employee emp2){
		this.emp1 = emp1;
		this.emp2 = emp2;
	}

//getters & setters
	public Employee getEmp1(){return emp1;}
	public Employee getEmp2(){return emp2;}

	public void setEmp1(Employee emp1){this.emp1 = emp1;}
	public void setEmp2(Employee emp2){this.emp2 = emp2;}


	//Method: average earnings
	public double averageEarnings(Employee emp){
		double total = 0;
		int times = 0;


		//find total and times made
		if(emp.getService1() != null){
			times = times + emp.getService1().getTimesMade();
			if (emp.getService1().getType() == "Corte de cabello"){
				total = total + (emp.getService1().getTimesMade() * 8000);
			}else if (emp.getService1().getType() == "Manicure") {
				total = total + (emp.getService1().getTimesMade() * 7000);
			}else if (emp.getService1().getType() == "Pedicure"){
				total = total + (emp.getService1().getTimesMade() * 9000);
			}
		}

		if(emp.getService2() != null){
			times = times + emp.getService2().getTimesMade();
			if (emp.getService2().getType() == "Corte de cabello"){
				total = total + (emp.getService2().getTimesMade() * 8000);
			}else if (emp.getService2().getType() == "Manicure") {
				total = total + (emp.getService2().getTimesMade() * 7000);
			}else if (emp.getService2().getType() == "Pedicure"){
				total = total + (emp.getService2().getTimesMade() * 9000);
			}
		}

		if(emp.getService3() != null){
			times = times + emp.getService3().getTimesMade();
			if (emp.getService3().getType() == "Corte de cabello"){
				total = total + (emp.getService3().getTimesMade() * 8000);
			}else if (emp.getService3().getType() == "Manicure") {
				total = total + (emp.getService3().getTimesMade() * 7000);
			}else if (emp.getService3().getType() == "Pedicure"){
				total = total + (emp.getService3().getTimesMade() * 9000);
			}
		}

		//average operation
		if(times == 0){
			return 0;
		}else{
			return total / times;
		}
	}

	
	


	public double findEarningsOfOneService(Employee emp, int selectServ){
		double total = 0;
		if (selectServ == 1) {
			total = emp.getService1().getEarnings()
		}else if (selectServ == 2) {
			total = emp.getService2().getEarnings()
		}else if (selectServ == 3) {
			total = emp.getService3().getEarnings()
		}else{
			System.out.println("OPCION INVALIDA, INGRESE DE NUEVO");
		}
		return total;
	}

	public void report(Employee emp, int selectServ){
		
		
		if (selectServ == 1&&emp.getService1() != null){
			if(emp.getService1().getTimesMade()<10 ){
				System.out.println("El empleado " + emp.getName() + " tiene " + emp.getService1().getTaxes() + " pesos de \nimpuestos acumulados por concepto de " + emp.getService1().getType());
			}else if(emp.getService1().getTimesMade() >= 10 && emp.getService1().getTimesMade() <= 20){
				System.out.println("El empleado " + emp.getName() + " con el servicio " + emp.getService1().getType() + " tiene " + emp.getService1().getEarnings() + " pesos de ingresos acumulados");
			}else{
				System.out.println("Felicitaciones a " + emp.getName() + "!!! La sala cubrira el valor de su impuesto");
				emp.getService1().setTaxes(0);
			}
		}else if (selectServ == 2&&emp.getService2() != null){
			if(emp.getService2().getTimesMade()<10 ){
				System.out.println("El empleado " + emp.getName() + " tiene " + emp.getService2().getTaxes() + " pesos de \nimpuestos acumulados por concepto de " + emp.getService2().getType());
			}else if(emp.getService2().getTimesMade() >= 10 && emp.getService2().getTimesMade() <= 20){
				System.out.println("El empleado " + emp.getName() + " con el servicio " + emp.getService2().getType() + " tiene " + emp.getService2().getEarnings() + " pesos de ingresos acumulados");
			}else{
				System.out.println("Felicitaciones a " + emp.getName() + "!!! La sala cubrira el valor de su impuesto");
				emp.getService2().setTaxes(0);
			}
		}else if (selectServ == 3&&emp.getService3() != null){
			if(emp.getService3().getTimesMade()<10 ){
				System.out.println("El empleado " + emp.getName() + " tiene " + emp.getService3().getTaxes() + " pesos de \nimpuestos acumulados por concepto de " + emp.getService2().getType());
			}else if(emp.getService3().getTimesMade() >= 10 && emp.getService3().getTimesMade() <= 20){
				System.out.println("El empleado " + emp.getName() + " con el servicio " + emp.getService3().getType() + " tiene " + emp.getService3().getEarnings() + " pesos de ingresos acumulados");
			}else{
				System.out.println("Felicitaciones a " + emp.getName() + "!!! La sala cubrira el valor de su impuesto");
				emp.getService3().setTaxes(0);
			}
		}else if(emp.getService1() == null){
			System.out.println("El empleado " + emp.getName() + " no presta el servicio");
		}else if(emp.getService2() == null){
			System.out.println("El empleado " + emp.getName() + " no presta el servicio");
		}else if(emp.getService3() == null){
			System.out.println("El empleado " + emp.getName() + " no presta el servicio");
		}
	}
}