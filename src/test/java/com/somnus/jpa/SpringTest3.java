package com.somnus.jpa;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.jpa.model.Person;
import com.somnus.jpa.repositories.PersonPagingRepsotory;

public class SpringTest3 extends AbstractTestSupport{
	
	
	@Test
	public void testPagingAndSortingRespository(){
		//pageNo 从 0 开始. 
		int pageNo = 6 - 1;
		int pageSize = 5;
		//Pageable 接口通常使用的其 PageRequest 实现类. 其中封装了需要分页的信息
		//排序相关的. Sort 封装了排序的信息
		//Order 是具体针对于某一个属性进行升序还是降序. 
		Order order1 = new Order(Direction.DESC, "id");
		Order order2 = new Order(Direction.ASC, "email");
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(pageNo, pageSize, sort);
		PersonPagingRepsotory repsotory = ApplicationContextHolder.getBean(PersonPagingRepsotory.class);
		Page<Person> page = repsotory.findAll(pageable);
		
		System.out.println("总记录数: " + page.getTotalElements());
		System.out.println("当前第几页: " + (page.getNumber() + 1));
		System.out.println("总页数: " + page.getTotalPages());
		System.out.println("当前页面的 List: " + page.getContent());
		System.out.println("当前页面的记录数: " + page.getNumberOfElements());
	}
	
}
