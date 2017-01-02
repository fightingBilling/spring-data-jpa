package com.somnus.jpa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.somnus.jpa.model.Person;

/**
 * 1. Repository 是一个空接口. 即是一个标记接口
 * 2. 若我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean.
 * 纳入到 IOC 容器中. 进而可以在该接口中定义满足一定规范的方法. 
 * 
 * 3. 实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
 */
/**
 * 在 Repository 子接口中声明方法
 * 1. 不是随便声明的. 而需要符合一定的规范
 * 2. 查询方法以 find | read | get 开头
 * 3. 涉及条件查询时，条件的属性用条件关键字连接
 * 4. 要注意的是：条件属性以首字母大写。
 * 5. 支持属性的级联查询. 若当前类有符合条件的属性, 则优先使用, 而不使用级联属性. 
 * 若需要使用级联属性, 则属性之间使用 _ 进行连接. 
 */
//@RepositoryDefinition(domainClass=Person.class,idClass=Integer.class)
public interface PersonRepsotory extends Repository<Person, Integer>{

	/**
	 * 根据 lastName 来获取对应的 Person
	 * @param lastName
	 * @return
	 */
	Person getByLastName(String lastName);
	
	/**
	 * WHERE lastName LIKE ?% AND id < ?
	 * @param lastName
	 * @param id
	 * @return
	 */
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);
	
	/**
	 * WHERE lastName LIKE %? AND id < ?
	 * @param lastName
	 * @param id
	 * @return
	 */
	List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);
	
	/**
	 * WHERE email IN (?, ?, ?) OR birth < ?
	 * @param emails
	 * @param birth
	 * @return
	 */
	List<Person> getByEmailInAndBirthLessThan(List<String> emails, Date birth);
	
	/**
	 * WHERE a.id > ?
	 * @param id
	 * @return
	 */
	List<Person> getByAddress_IdGreaterThan(Integer id);
	
	/**
	 * 查询 id 值最大的那个 Person
	 * 使用 @Query 注解可以自定义 JPQL 语句以实现更灵活的查询
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
	Person getMaxIdPerson();
	
	/**
	 * 为 @Query 注解传递参数的方式1: 使用占位符. 
	 * @param lastName
	 * @param email
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
	List<Person> testQueryAnnotationParams1(String lastName, String email);
	
	/**
	 * 为 @Query 注解传递参数的方式1: 命名参数的方式. 
	 * @param email
	 * @param lastName
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
	List<Person> testQueryAnnotationParams2(@Param("email") String email, @Param("lastName") String lastName);
	
	/**
	 * SpringData 允许在占位符上添加 %%. 
	 * @param lastName
	 * @param email
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
	List<Person> testQueryAnnotationLikeParam(String lastName, String email);
	
	/**
	 * SpringData 允许在占位符上添加 %%. 
	 * @param email
	 * @param lastName
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
	List<Person> testQueryAnnotationLikeParam2(@Param("email") String email, @Param("lastName") String lastName);
	
	/**
	 * 设置 nativeQuery=true 即可以使用原生的 SQL 查询
	 * @return
	 */
	@Query(value="SELECT count(id) FROM jpa_persons", nativeQuery=true)
	long getTotalCount();
	
}
 