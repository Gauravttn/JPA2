package ttn.bootcamp.JPA2;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface EmployeeInterface extends CrudRepository<Employee, Integer> {

	@Query("select e.firstName,e.lastName from Employee e where salary>(select AVG(salary) from Employee) Order By age ASC, salary DESC")
	List<Object[]> findBySal();
	
	@Query("from Employee")
	List<Employee> find();

	
//    @Modifying
//    @Transactional
//    @Query("update Employee e set e.salary=:salary where e.salary<"+ "(select AVG(e.salary) from Employee)")
//    void updateEmpSal(@Param("salary") int salary);
    
    @Query("Update Employee set salary=:salary where salary <:findAvgSalary") 	
    @Modifying 	
    public void updateEmpSal(@Param("salary") int salary, @Param("findAvgSalary") int findAvgSalary); 	
    
    @Query("select AVG(salary) from Employee") 	 
    int findAvgSalary();
    
    @Query(" DELETE FROM Employee WHERE salary < :findMinSalary") 	
    @Modifying 	
    public void deleteEmpWithMinSal( @Param("findMinSalary") int findMinSalary); 	
    
    @Query("select MIN(salary) from Employee") 	 
    int findMinSalary();
    
    @Query(value = "select emp_id,emp_first_name,emp_age from employee_table where " +
            "emp_last_name like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmpNameEndsWith();
    
    @Modifying
    @Transactional
    @Query(value = "delete from employee_table where emp_age>:age", nativeQuery = true)
    void deleteEmpAgeGreater(@Param("age") int age);
}
    

