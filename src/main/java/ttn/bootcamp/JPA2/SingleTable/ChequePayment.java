package ttn.bootcamp.JPA2.SingleTable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
 
@Entity
@DiscriminatorValue(value = "cheque")
public class ChequePayment extends PaymentSingleTable {
	
	private String chequenumber;

	public String getChequenumber() {
		return chequenumber;
	}

	public void setChequenumber(String chequenumber) {
		this.chequenumber = chequenumber;
	}



}
