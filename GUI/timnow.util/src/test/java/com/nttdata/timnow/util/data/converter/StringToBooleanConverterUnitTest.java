package com.nttdata.timnow.util.data.converter;

import org.junit.Assert;
import org.junit.Test;

import com.nttdata.tim.now.util.data.converter.StringToBooleanConverter;

public class StringToBooleanConverterUnitTest {

	@Test
	public void stringToBoolean() throws Exception {
		StringToBooleanConverter converter = new StringToBooleanConverter();

		boolean actualValue = converter.convertTo("Y", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("y", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("S", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("s", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("Yes", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("YES", true);
		Assert.assertEquals(true, actualValue);

		actualValue = converter.convertTo("TRUE", true);
		Assert.assertEquals(true, actualValue);
		
		actualValue = converter.convertTo("true", true);
		Assert.assertEquals(true, actualValue);
		
		actualValue = converter.convertTo("N", false);
		Assert.assertEquals(false, actualValue);

		actualValue = converter.convertTo("n", false);
		Assert.assertEquals(false, actualValue);
	}

	@Test
	public void booleanToString() throws Exception {
		StringToBooleanConverter converter = new StringToBooleanConverter();

		String actualValue = converter.convertFrom(true, "Y");
		Assert.assertEquals("Y", actualValue);

		actualValue = converter.convertFrom(false, "N");
		Assert.assertEquals("N", actualValue);
	}

}
