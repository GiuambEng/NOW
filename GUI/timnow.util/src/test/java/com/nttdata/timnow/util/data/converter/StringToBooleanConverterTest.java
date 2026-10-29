package com.nttdata.timnow.util.data.converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nttdata.tim.now.util.data.DozerHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test/applicationContext-util.xml", })
public class StringToBooleanConverterTest {

	@Autowired
	private DozerHelper mapper;

	@Test
	public void stringToBoolean() throws Exception {
		boolean actualValue = mapper.translate("Y", Boolean.class);
		Assert.assertEquals(true, actualValue);

		actualValue = mapper.translate("y", Boolean.class);
		Assert.assertEquals(true, actualValue);

		actualValue = mapper.translate("S", Boolean.class);
		Assert.assertEquals(true, actualValue);

		actualValue = mapper.translate("s", Boolean.class);
		Assert.assertEquals(true, actualValue);

		actualValue = mapper.translate("YES", Boolean.class);
		Assert.assertEquals(true, actualValue);
		
		actualValue = mapper.translate("Yes", Boolean.class);
		Assert.assertEquals(true, actualValue);
		
		actualValue = mapper.translate("TRUE", Boolean.class);
		Assert.assertEquals(true, actualValue);
		
		actualValue = mapper.translate("true", Boolean.class);
		Assert.assertEquals(true, actualValue);

		actualValue = mapper.translate("N", Boolean.class);
		Assert.assertEquals(false, actualValue);

		actualValue = mapper.translate("n", Boolean.class);
		Assert.assertEquals(false, actualValue);
	}

	@Test
	public void booleanToString() throws Exception {
		String actualValue = mapper.translate(true, String.class);
		Assert.assertEquals("Y", actualValue);

		actualValue = mapper.translate(false, String.class);
		Assert.assertEquals("N", actualValue);
	}

}
