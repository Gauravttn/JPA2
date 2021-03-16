package ttn.bootcamp.JPA2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="employeeTable")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="empId")
	private int id;
	
	@Column(name="empSalary")
	private int salary;
	
	@Column(name="empAge")
	private int age;
	
	@Column(name="empFirstName")
	private String firstName;
	
	@Column(name="empLastName")
	private String lastName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	

}
