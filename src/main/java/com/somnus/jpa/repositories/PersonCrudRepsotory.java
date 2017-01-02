package com.somnus.jpa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.somnus.jpa.model.Person;

public interface PersonCrudRepsotory extends CrudRepository<Person, Integer>{
	
	/**
	 * 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作. 注意: JPQL 不支持使用 INSERT
	 * 在 @Query 注解中编写 JPQL 语句, 但必须使用 @Modifying 进行修饰. 以通知 SpringData, 这是一个 UPDATE 或 DELETE 操作
	 * UPDATE 或 DELETE 操作需要使用事务, 此时需要定义 Service 层. 在 Service 层的方法上添加事务操作. 
	 * 默认情况下, SpringData 的每个方法上有事务, 但都是一个只读事务. 他们不能完成修改操作!
	 * @param id
	 * @param email
	 */
	@Modifying
	@Query("UPDATE Person p SET p.email = :email WHERE id = :id")
	void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);

}
