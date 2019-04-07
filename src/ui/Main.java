package ui;

import model.*;
import java.util.Scanner;

public class Main{
	public void init(){
		//objetos
		Employee emp1 = new Employee("Sandra", 29533730, "Due\u00f1a y propietaria", 2010, null, null, null);
		Employee emp2 = new Employee("Carmen", 29307130, "Estilista general", 2012, null, null, null);
		
	}

	public Main(){
		init();

	}

	public void menu(){
		//interfaz System.out.println();
		System.out.println("	 ________________________________________ ");
		System.out.println("	|----------------------------------------|");
		System.out.println("	|---------------Bienvenido---------------|");
		System.out.println("	|                                        |");
		System.out.println("	|   Que desea hacer?                     |");
		System.out.println("	|   1.Ver empleados                      |");
		System.out.println("	|   2.Registrar servicio                 |");
		System.out.println("	|   3.Actualizar servicio                |");
		System.out.println("	|   4.Calcular promedio de ganancias     |");
		System.out.println("	|   5.Calcular ingresos de un servicio   |");
		System.out.println("	|   6.Dar reporte                        |");
		System.out.println("	|   0.Salir                              |");
		System.out.println("	'----------------------------------------'");


	}

	public static void main(String[] args) {
		int select = 0;
		int i = 0;
		Employee emp1 = new Employee("Sandra", 29533730, "Due\u00f1a y propietaria", 2010, null, null, null);
		Employee emp2 = new Employee("Carmen", 29307130, "Estilista general", 2012, null, null, null);
		Place style = new Place(emp1, emp2);
		do{
			Main main = new Main();
			Scanner s = new Scanner(System.in);
			main.menu();
			select = s.nextInt();




			if(select == 0){//EXIT
				System.exit(0);
			}else if(select == 1){//SEE EMPLOYEES
				System.out.println("1)##############################" + emp1 + "\n################################\n");
				System.out.println("2)##############################" + emp2 + "\n################################");
			}else if(select == 2){//REGISTER SERVICE
				System.out.println("Escoja el empleado al que le va a registrar el servicio:");
				System.out.println("1)##############################" + emp1 + "\n################################\n");
				System.out.println("2)##############################" + emp2 + "\n################################");

				int i2 = 0;
				do{
					select = s.nextInt();
					s.nextLine();

					if (select == 1) {
						System.out.println("Elija el tipo del servicio:");
						System.out.println("1.Manicure");
						System.out.println("2.Pedicure");
						System.out.println("3.Corte de cabello");

						select = s.nextInt();
						int i3 = 0;
						String type = "";
						do{
							if (select == 1) {
								type = "Manicure";
								i3++;
							}else if (select == 2) {
								type = "Pedicure";
								i3++;
							}else if (select == 3) {
								type = "Corte de cabello";
								i3++;
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}while(i3<1);

						int timesMade = 0;
						double earnings = 0;
						double taxes = 0;

						emp1.registerService(type, timesMade, earnings, taxes);
						i2++;
					}else if (select == 2) {
						System.out.println("Elija el tipo del servicio:");
						System.out.println("1.Manicure");
						System.out.println("2.Pedicure");
						System.out.println("3.Corte de cabello");

						select = s.nextInt();
						int i3 = 0;
						String type = "";
						do{
							if (select == 1) {
								type = "Manicure";
								i3++;
							}else if (select == 2) {
								type = "Pedicure";
								i3++;
							}else if (select == 3) {
								type = "Corte de cabello";
								i3++;
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}while(i3<1);
						
						int timesMade = 0;
						double earnings = 0;
						double taxes = 0;	

						emp2.registerService(type, timesMade, earnings, taxes);
						i2++;
					}else{
						System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
					}
				}while(i2<1);
			}else if(select == 3){//UPDATE SERVICE
				int i2 = 0;
				do{
					System.out.println("Escoja el empleado:");
					System.out.println("1)##############################" + emp1 + "\n################################\n");
					System.out.println("2)##############################" + emp2 + "\n################################");
					select = s.nextInt();
					if (select == 1) {
						i2++;
						int i3 = 0;
						do{
							System.out.println("Escoja el servicio a actualizar");
							System.out.println("1)---------------" + emp1.getService1() + "\n-----------------\n");
							System.out.println("2)---------------" + emp1.getService2() + "\n-----------------\n");
							System.out.println("3)---------------" + emp1.getService3() + "\n-----------------\n");
							select = s.nextInt();

							System.out.println("Inserte cuantas veces mas se hizo el servicio:");
							int num = s.nextInt();

							emp1.updateService(num, select);
							if(select == 1 || select == 2 || select == 3){
								i3++;
							}
						}while(i3<1);
					}else if (select == 2) {
						i2++;
						int i3 = 0;
						do{
							System.out.println("Escoja el servicio a actualizar");
							System.out.println("1)---------------" + emp2.getService1() + "\n-----------------\n");
							System.out.println("2)---------------" + emp2.getService2() + "\n-----------------\n");
							System.out.println("3)---------------" + emp2.getService3() + "\n-----------------\n");
							select = s.nextInt();

							System.out.println("Inserte cuantas veces mas se hizo el servicio:");
							int num = s.nextInt();

							emp1.updateService(num, select);
							if(select == 1 || select == 2 || select == 3){
								i3++;
							}
						}while(i3<1);
					}else{
						System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
					}
				}while(i2<1);


				//SET or UPDATE EARNINGS & TAXES (AUTO)
				//EMPLOYEE #1
				if(emp1.getService1() != null){
					if (emp1.getService1().getType() == "Manicure") {
						double total = (emp1.getService1().getEarnings() + (emp1.getService1().getTimesMade() * 7000))*0.35;
						emp1.getService1().setEarnings(total);
						double taxes = emp1.getService1().getTaxes() + (7000 * 0.19);
						emp1.getService1().setTaxes(taxes);
					}else if (emp1.getService1().getType() == "Pedicure") {
						double total = (emp1.getService1().getEarnings() + (emp1.getService1().getTimesMade() * 9000))*0.25;
						emp1.getService1().setEarnings(total);
						double taxes = emp1.getService1().getTaxes() + (9000 * 0.19);
						emp1.getService1().setTaxes(taxes);
					}else if (emp1.getService1().getType() == "Corte de cabello") {
						double total = (emp1.getService1().getEarnings() + (emp1.getService1().getTimesMade() * 8000))*0.2;
						emp1.getService1().setEarnings(total);
						double taxes = emp1.getService1().getTaxes() + (8000 * 0.19);
						emp1.getService1().setTaxes(taxes);
					}
				}

				if(emp1.getService2() != null){
					if (emp1.getService2().getType() == "Manicure") {
						double total = (emp1.getService2().getEarnings() + (emp1.getService2().getTimesMade() * 7000))*0.35;
						emp1.getService2().setEarnings(total);
						double taxes = emp1.getService2().getTaxes() + (7000 * 0.19);
						emp1.getService2().setTaxes(taxes);
					}else if (emp1.getService2().getType() == "Pedicure") {
						double total = (emp1.getService2().getEarnings() + (emp1.getService2().getTimesMade() * 9000))*0.25;
						emp1.getService2().setEarnings(total);
						double taxes = emp1.getService2().getTaxes() + (9000 * 0.19);
						emp1.getService2().setTaxes(taxes);
					}else if (emp1.getService2().getType() == "Corte de cabello") {
						double total = (emp1.getService2().getEarnings() + (emp1.getService2().getTimesMade() * 8000))*0.2;
						emp1.getService2().setEarnings(total);
						double taxes = emp1.getService2().getTaxes() + (8000 * 0.19);
						emp1.getService2().setTaxes(taxes);
					}
				}

				if(emp1.getService3() != null){
					if (emp1.getService3().getType() == "Manicure") {
						double total = (emp1.getService3().getEarnings() + (emp1.getService3().getTimesMade() * 7000))*0.35;
						emp1.getService3().setEarnings(total);
						double taxes = emp1.getService3().getTaxes() + (7000 * 0.19);
						emp1.getService3().setTaxes(taxes);
					}else if (emp1.getService3().getType() == "Pedicure") {
						double total = (emp1.getService3().getEarnings() + (emp1.getService3().getTimesMade() * 9000))*0.25;
						emp1.getService3().setEarnings(total);
						double taxes = emp1.getService3().getTaxes() + (9000 * 0.19);
						emp1.getService3().setTaxes(taxes);
					}else if (emp1.getService3().getType() == "Corte de cabello") {
						double total = (emp1.getService3().getEarnings() + (emp1.getService3().getTimesMade() * 8000))*0.2;
						emp1.getService3().setEarnings(total);
						double taxes = emp1.getService3().getTaxes() + (8000 * 0.19);
						emp1.getService3().setTaxes(taxes);
					}
				}


				//EMPLYEE #2
				if(emp2.getService1() != null){
					if (emp2.getService1().getType() == "Manicure") {
						double total = (emp2.getService1().getEarnings() + (emp2.getService1().getTimesMade() * 7000))*0.35;
						emp2.getService1().setEarnings(total);
						double taxes = emp2.getService1().getTaxes() + (7000 * 0.19);
						emp2.getService1().setTaxes(taxes);
					}else if (emp2.getService1().getType() == "Pedicure") {
						double total = (emp2.getService1().getEarnings() + (emp2.getService1().getTimesMade() * 9000))*0.25;
						emp2.getService1().setEarnings(total);
						double taxes = emp2.getService1().getTaxes() + (9000 * 0.19);
						emp2.getService1().setTaxes(taxes);
					}else if (emp2.getService1().getType() == "Corte de cabello") {
						double total = (emp2.getService1().getEarnings() + (emp2.getService1().getTimesMade() * 8000))*0.2;
						emp2.getService1().setEarnings(total);
						double taxes = emp2.getService1().getTaxes() + (8000 * 0.19);
						emp2.getService1().setTaxes(taxes);
					}
				}

				if(emp2.getService2() != null){
					if (emp2.getService2().getType() == "Manicure") {
						double total = (emp2.getService2().getEarnings() + (emp2.getService2().getTimesMade() * 7000))*0.35;
						emp2.getService2().setEarnings(total);
						double taxes = emp2.getService2().getTaxes() + (7000 * 0.19);
						emp2.getService2().setTaxes(taxes);
					}else if (emp2.getService2().getType() == "Pedicure") {
						double total = (emp2.getService2().getEarnings() + (emp2.getService2().getTimesMade() * 9000))*0.25;
						emp2.getService2().setEarnings(total);
						double taxes = emp2.getService2().getTaxes() + (9000 * 0.19);
						emp2.getService2().setTaxes(taxes);
					}else if (emp2.getService2().getType() == "Corte de cabello") {
						double total = (emp2.getService2().getEarnings() + (emp2.getService2().getTimesMade() * 8000))*0.2;
						emp2.getService2().setEarnings(total);
						double taxes = emp2.getService2().getTaxes() + (8000 * 0.19);
						emp2.getService2().setTaxes(taxes);
					}
				}

				if(emp2.getService3() != null){
					if (emp2.getService3().getType() == "Manicure") {
						double total = (emp2.getService3().getEarnings() + (emp2.getService3().getTimesMade() * 7000))*0.35;
						emp2.getService3().setEarnings(total);
						double taxes = emp2.getService3().getTaxes() + (7000 * 0.19);
						emp2.getService3().setTaxes(taxes);
					}else if (emp2.getService3().getType() == "Pedicure") {
						double total = (emp2.getService3().getEarnings() + (emp2.getService3().getTimesMade() * 9000))*0.25;
						emp2.getService3().setEarnings(total);
						double taxes = emp2.getService3().getTaxes() + (9000 * 0.19);
						emp2.getService3().setTaxes(taxes);
					}else if (emp2.getService3().getType() == "Corte de cabello") {
						double total = (emp2.getService3().getEarnings() + (emp2.getService3().getTimesMade() * 8000))*0.2;
						emp2.getService3().setEarnings(total);
						double taxes = emp2.getService3().getTaxes() + (8000 * 0.19);
						emp2.getService3().setTaxes(taxes);
					}
				}
			}else if(select == 4){//CALCULATE AVERAGE OF EARNINGS OF AN EMPLOYEE
				int i2 = 0;
				do{
					System.out.println("Escoja el empleado:");
					System.out.println("1)##############################" + emp1 + "\n################################\n");
					System.out.println("2)##############################" + emp2 + "\n################################");
					select = s.nextInt();

					if (select == 1) {
						System.out.println(style.averageEarnings(emp1));
						i2++;
					}else if (select == 2) {
						System.out.println(style.averageEarnings(emp2));
						i2++;
					}else{
						System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
					}
				}while(i2<1);
			}else if(select == 5){//CALCULATE EARNINGS OF A SERVICE
				int i2 = 0;
				do{
					System.out.println("Escoja el empleado:");
					System.out.println("1)##############################" + emp1 + "\n################################\n");
					System.out.println("2)##############################" + emp2 + "\n################################");
					select = s.nextInt();

				
					if(select == 1){
						i2++;
						int i3 = 0;
						do{
						 	System.out.println("Elija el servicio: ");
						 	System.out.println("1)---------------" + emp1.getService1() + "\n-----------------\n");
							System.out.println("2)---------------" + emp1.getService2() + "\n-----------------\n");
							System.out.println("3)---------------" + emp1.getService3() + "\n-----------------\n");
							select = s.nextInt();

							if (select == 1) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp1, select));
							}else if (select == 2) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp1, select));
							}else if (select == 3) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp1, select));
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}(while i3<0);
					}else if(select == 2){
						i2++;
						int i3 = 0;
						do{
						 	System.out.println("Elija el servicio: ");
						 	System.out.println("1)---------------" + emp1.getService1() + "\n-----------------\n");
							System.out.println("2)---------------" + emp1.getService2() + "\n-----------------\n");
							System.out.println("3)---------------" + emp1.getService3() + "\n-----------------\n");
							select = s.nextInt();

						
							if (select == 1) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp2, select));
							}else if (select == 2) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp2, select));
							}else if (select == 3) {
								i3++;
								System.out.println(style.findEarningsOfOneService(emp2, select));
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}(while i3<0);
					}else{
						System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
					}
				}(while i2<1);
			}else if(select == 6){//GIVE REPORT
				int i2 = 0;
				do{
					System.out.println("Escoja el empleado:");
					System.out.println("1)##############################" + emp1 + "\n################################\n");
					System.out.println("2)##############################" + emp2 + "\n################################");
					select = s.nextInt();
					 if(select == 1){
					 	i2++;
					 	System.out.println("Elija el servicio: ");
					 	System.out.println("1)---------------" + emp1.getService1() + "\n-----------------\n");
						System.out.println("2)---------------" + emp1.getService2() + "\n-----------------\n");
						System.out.println("3)---------------" + emp1.getService3() + "\n-----------------\n");
						select = s.nextInt();

						int i3 = 0;
						do{
							if(select == 1){
								i3++;
								style.report(emp1, select);
							}else if(select == 2){
								i3++;
								style.report(emp1, select);
							}else if(select == 3){
								i3++;
								style.report(emp1, select);
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}while(i3<1);
					}else if(select == 2){
						i2++;
						System.out.println("Elija el servicio: ");
					 	System.out.println("1)---------------" + emp2.getService1() + "\n-----------------\n");
						System.out.println("2)---------------" + emp2.getService2() + "\n-----------------\n");
						System.out.println("3)---------------" + emp2.getService3() + "\n-----------------\n");
						select = s.nextInt();

						int i3 = 0;
						do{
							if(select == 1){
								i3++;
								style.report(emp2, select);
							}else if(select == 2){
								i3++;
								style.report(emp2, select);
							}else if(select == 3){
								i3++;
								style.report(emp2, select);
							}else{
								System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
							}
						}while(i3<1);
					}else{
						System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
					}
				}while(i2<1);
			}else{
				System.out.println("OPCION NO VALIDA, INGRESE DE NUEVO");
			}
		}while(i<1);

	}
}