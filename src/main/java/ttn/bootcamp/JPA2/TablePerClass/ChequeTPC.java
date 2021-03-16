package ttn.bootcamp.JPA2.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "chequeperclass")
public class ChequeTPC extends PaymentTPC {
	

	
	private String chequenumber;

	public String getChequenumber() {
		return chequenumber;
	}

	public void setChequenumber(String chequenumber) {
		this.chequenumber = chequenumber;
	}


}
