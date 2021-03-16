package ttn.bootcamp.JPA2.SingleTable;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<PaymentSingleTable, Integer>
{

}
