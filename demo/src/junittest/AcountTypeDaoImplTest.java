package junittest;

import java.util.ArrayList;
import java.util.List;

import myAnswer.bean.AcountType;
import myAnswer.dao.AcountTypeDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AcountTypeDaoImplTest {

	ApplicationContext ct;
	AcountTypeDao typeImpl;
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		typeImpl=(AcountTypeDao) ct.getBean("typeDaoImpl");
	}
	
	@Test
	public void testsave()
	{
		AcountType type=new AcountType();
		type.setTypename("ª·‘±");
		List<AcountType> list=new ArrayList<AcountType>();
		list.add(type);
		typeImpl.save(list);
	}
	@Test
	public void test()
	{
	}
	

}
