package ttn.bootcamp.JPA2.Mapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Salary {
	@Column(name = "basicsalary")
	private Double basicSalary;
	@Column(name = "bonussalary")
	private Double bonusSalary;
	@Column(name = "taxallowance")
	private Double taxAllowance;
	@Column(name = "specialallowancesalary") 
	private Double specialAllowanceSalary;
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Double getBonusSalary() {
		return bonusSalary;
	}
	public void setBonusSalary(Double bonusSalary) {
		this.bonusSalary = bonusSalary;
	}
	public Double getTaxAllowance() {
		return taxAllowance;
	}
	public void setTaxAllowance(Double taxAllowance) {
		this.taxAllowance = taxAllowance;
	}
	public Double getSpecialAllowanceSalary() {
		return specialAllowanceSalary;
	}
	public void setSpecialAllowanceSalary(Double specialAllowanceSalary) {
		this.specialAllowanceSalary = specialAllowanceSalary;
	}


}
