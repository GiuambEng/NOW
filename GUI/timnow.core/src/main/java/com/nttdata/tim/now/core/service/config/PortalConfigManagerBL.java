package com.nttdata.tim.now.core.service.config;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.date.DateHelper;
import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.springframework.stereotype.Service;

@Service
public class PortalConfigManagerBL extends AbstractBL {

    public Map<String, Object> getFEConfiguration() {
        Properties feProperties = PropertiesHelper.getFEProperties();
        @SuppressWarnings({ "unchecked", "rawtypes" })
        Map<String, Object> map = (Map) feProperties;
        try {
            map.put(Constants.FE_TODAY_CONFIG_PROPERTY, DateHelper.getFormatDateString(new Date(), DateHelper.DATE_FE));
        } catch (ParseException e) {
            logger.debug("Error parsing date", e);
        }
        return map;
    }

    
    
}
