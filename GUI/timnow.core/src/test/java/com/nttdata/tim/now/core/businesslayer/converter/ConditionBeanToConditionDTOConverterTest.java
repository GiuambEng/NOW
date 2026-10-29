package com.nttdata.tim.now.core.businesslayer.converter;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nttdata.tim.now.data.bean.ricerca.ConditionBean;
import com.nttdata.tim.now.data.dto.ricerca.ConditionDTO;
import com.nttdata.tim.now.data.enumeration.ConditionType;
import com.nttdata.tim.now.util.data.DozerHelper;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test/applicationContext-core.xml", })
public class ConditionBeanToConditionDTOConverterTest {


	@Autowired
	DozerHelper mapper;
	
	@Test
	public void conditionBeanToConditionDTO() throws Exception {
		ConditionBean conditionBean;
		ConditionDTO conditionDTO;
		
		// Testa la conversione dei dati di tipo DATE.
		conditionBean = new ConditionBean();
		conditionBean.setNome("nome");
		conditionBean.setOperazione("operazione");
		conditionBean.setTipo(ConditionType.DATE.name());
		conditionBean.setValore("02/01/1970");
		
		conditionDTO = mapper.translate(conditionBean, ConditionDTO.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("DATE", conditionDTO.getTipo());
		assertEquals("1970-01-02", conditionDTO.getValore());
		
		// In caso di data con formato non conforme viene restituito null ma
		// non viene rilanciato nessun errore.
		conditionBean = new ConditionBean();
		conditionBean.setNome("nome");
		conditionBean.setOperazione("operazione");
		conditionBean.setTipo(ConditionType.DATE.name());
		conditionBean.setValore("21-01-1970");
		
		conditionDTO = mapper.translate(conditionBean, ConditionDTO.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("DATE", conditionDTO.getTipo());
		assertEquals(null, conditionDTO.getValore());
		
		// Testa la conversione dei dati di tipo INT.
		conditionBean = new ConditionBean();
		conditionBean.setNome("nome");
		conditionBean.setOperazione("operazione");
		conditionBean.setTipo(ConditionType.INT.name());
		conditionBean.setValore("12");
		
		conditionDTO = mapper.translate(conditionBean, ConditionDTO.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("INT", conditionDTO.getTipo());
		assertEquals("12", conditionDTO.getValore());
		
		// Testa la conversione dei dati di tipo String.
		conditionBean = new ConditionBean();
		conditionBean.setNome("nome");
		conditionBean.setOperazione("operazione");
		conditionBean.setTipo(ConditionType.STRING.name());
		conditionBean.setValore("string");
		
		conditionDTO = mapper.translate(conditionBean, ConditionDTO.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("STRING", conditionDTO.getTipo());
		assertEquals("string", conditionDTO.getValore());
	}
	
	@Test
	public void conditionDTOToConditionBean() throws Exception {
		ConditionBean conditionBean;
		ConditionDTO conditionDTO;
		
		// Testa la conversione dei dati di tipo DATE.
		conditionDTO = new ConditionDTO();
		conditionDTO.setNome("nome");
		conditionDTO.setOperazione("operazione");
		conditionDTO.setTipo(ConditionType.DATE.name());
		conditionDTO.setValore("02/01/1970");
		
		conditionBean = mapper.translate(conditionDTO, ConditionBean.class);
		assertEquals("nome", conditionBean.getNome());
		assertEquals("operazione", conditionBean.getOperazione());
		assertEquals("DATE", conditionBean.getTipo());
		assertEquals("02/01/1970", conditionBean.getValore());
		
		// Testa la conversione dei dati di tipo INT.
		conditionDTO = new ConditionDTO();
		conditionDTO.setNome("nome");
		conditionDTO.setOperazione("operazione");
		conditionDTO.setTipo(ConditionType.INT.name());
		conditionDTO.setValore("12");
		
		conditionBean = mapper.translate(conditionBean, ConditionBean.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("INT", conditionDTO.getTipo());
		assertEquals("12", conditionDTO.getValore());
		
		// Testa la conversione dei dati di tipo String.
		conditionDTO = new ConditionDTO();
		conditionDTO.setNome("nome");
		conditionDTO.setOperazione("operazione");
		conditionDTO.setTipo(ConditionType.STRING.name());
		conditionDTO.setValore("string");
		
		conditionBean = mapper.translate(conditionDTO, ConditionBean.class);
		assertEquals("nome", conditionDTO.getNome());
		assertEquals("operazione", conditionDTO.getOperazione());
		assertEquals("STRING", conditionDTO.getTipo());
		assertEquals("string", conditionDTO.getValore());
	}
	
}
