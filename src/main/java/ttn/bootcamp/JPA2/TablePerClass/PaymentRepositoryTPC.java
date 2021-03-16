package ttn.bootcamp.JPA2.TablePerClass;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepositoryTPC extends CrudRepository<PaymentTPC, Integer> {

}
