package ttn.bootcamp.JPA2;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ttn.bootcamp.JPA2.Joined.Card;
import ttn.bootcamp.JPA2.Joined.Cheque;
import ttn.bootcamp.JPA2.Joined.PaymentRepoJoined;
import ttn.bootcamp.JPA2.Mapping.EmployeeMapRepository;
import ttn.bootcamp.JPA2.Mapping.EmployeeMapping;
import ttn.bootcamp.JPA2.Mapping.Salary;
import ttn.bootcamp.JPA2.SingleTable.CardPayment;
import ttn.bootcamp.JPA2.SingleTable.ChequePayment;
import ttn.bootcamp.JPA2.SingleTable.PaymentRepository;
import ttn.bootcamp.JPA2.TablePerClass.CardTPC;
import ttn.bootcamp.JPA2.TablePerClass.ChequeTPC;
import ttn.bootcamp.JPA2.TablePerClass.PaymentRepositoryTPC;

@SpringBootTest
class Jpa2ApplicationTests {
	
	@Autowired
	EmployeeInterface repo;
	
	@Autowired
	PaymentRepository pRepo;
	
	@Autowired
	PaymentRepoJoined repoJoined;
	
	@Autowired
	PaymentRepositoryTPC repoTPC;
	
	@Autowired
	EmployeeMapRepository repomap;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void getEmpSalLessThanAvg() {
		
		List<Object[]> res = repo.findBySal();
		res.forEach(p->System.out.println("FIRST NAME :- "+p[0]+" LAST NAME :- " +p[1] ));

	}
	
//	@Test
//	void updateEmpSal() {
//		repo.updateEmpSal(10000);
//		System.out.println("Done");
//	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void updateEmpSalThanAvg()
	{ 		
		int salary = 80000; 		
		repo.updateEmpSal(salary, repo.findAvgSalary());
		System.out.println("**************************Employees Updated*******************************"); 	
		}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void delEmpMinSal() {
		
		repo.deleteEmpWithMinSal(repo.findMinSalary());
		System.out.println("**************************Employees Deleted*******************************"); 	

	}
	
	@Test
	public void showEmpNameWithSingh() {
		List<Object[]> res = repo.getAllEmpNameEndsWith();
		res.forEach(p->System.out.println("ID :- "+p[0]+"  FIRST NAME :- "+p[1]+"	AGE :- " +p[2] ));

	}
	
	@Test
	public void delEmp() {
		repo.deleteEmpAgeGreater(45);
		System.out.println("**************************Employees Deleted*******************************"); 	

	}
	
	@Test
	public void add() {
		Employee emp=new Employee();
		emp.setAge(24);
		emp.setFirstName("Shubham");
		emp.setLastName("Singh");
		emp.setSalary(5000);
		repo.save(emp);
		System.out.println("**************************Employees Created*******************************"); 	

		
	}
	
	
	// SINGLE TABLE INHERITANCE
	
	@Test
	public void CreateCardPayment() {
		CardPayment card=new CardPayment();
		card.setId(2);
		card.setAmount(2000d);
		card.setCardnumber("12344321");
		
		pRepo.save(card);
		System.out.println("\n**********Card Payment Details Entered in Table************\n");
	}
	
	@Test
	public void CreateChequePayment() {
		ChequePayment chq=new ChequePayment();
		chq.setChequenumber("3457654");
		chq.setAmount(1000d);
		chq.setId(3);
		
		pRepo.save(chq);
		System.out.println("\n**********Cheque Payment Details Entered in Table************\n");

	}
	
	// Joined INHERITANCE
	
	@Test
	public void CreateCardPaymentJoined() {
		Card card=new Card();
		card.setId(2);
		card.setAmount(2000d);
		card.setCardnumber("12344321");
		
		repoJoined.save(card);
		System.out.println("\n**********Card Payment Details Entered in Table************\n");
	}
	
	@Test
	public void CreateChequePaymentJoined() {
		Cheque chq=new Cheque();
		chq.setChequenumber("3457654");
		chq.setAmount(1000d);
		chq.setId(3);
		
		repoJoined.save(chq);
		System.out.println("\n**********Cheque Payment Details Entered in Table************\n");

	}
	
	// TABLE PER CLASS INHERITANCE
	
	@Test
	public void CreateCardPaymentTPC() {
		CardTPC card=new CardTPC();
			card.setId(2);
			card.setAmount(2000d);
			card.setCardnumber("123321123");
		
		repoTPC.save(card);
		System.out.println("\n**********Card Payment Details Entered in Table************\n");
	}
	
	@Test
	public void CreateChequePaymentTPC() {
		ChequeTPC chq=new ChequeTPC();
		chq.setChequenumber("3457654");
		chq.setAmount(1000d);
		chq.setId(3);
		
		repoTPC.save(chq);
		System.out.println("\n**********Cheque Payment Details Entered in Table************\n");

	}
	
	//	EMPLOYEE COMPONENT MAPPING
	
	@Test
	public void empMap() {
		EmployeeMapping emp=new EmployeeMapping();
		emp.setId(1);
		emp.setAge(23);
		emp.setFirstName("Gaurav");
		emp.setLastName("Kumar");
		Salary salary=new Salary();
		salary.setBasicSalary(45000d);
		salary.setBonusSalary(7500d);
		salary.setSpecialAllowanceSalary(2000d);
		salary.setTaxAllowance(2000d);
		emp.setSalary(salary);
		
		repomap.save(emp);
		System.out.println("\n**********Employee - salary Mapped and Entered in Table************\n");

	}
	
	
	

}
