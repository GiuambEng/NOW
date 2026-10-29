package com.nttdata.tim.now.util.data.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringDateToStringDateConverter extends DozerConverter<String, String> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	public StringDateToStringDateConverter() {
		super(String.class, String.class);
	}

	//Bean -> DTO
	@Override
	public String convertTo(String source, String destination) {
		if (source != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date dateSource = formatter.parse(source);
				destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_BE);
			} catch (ParseException e) {
				logger.debug("Parse error", e);
			}
		}
		return destination;
	}

	//DTO -> Bean
	@Override
	public String convertFrom(String source, String destination) {
		if (source != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dateSource = formatter.parse(source);
				destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_FE);
			} catch (ParseException e) {
				logger.debug("Parse error", e);
			}
		}
		return destination;
	}
}
