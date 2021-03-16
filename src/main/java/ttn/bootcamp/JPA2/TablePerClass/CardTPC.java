package ttn.bootcamp.JPA2.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cardperclass")
public class CardTPC extends PaymentTPC {


	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}


}
