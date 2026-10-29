package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.AnagDisaggregazioneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficadisaggregazione.AnagraficaDisaggregazioneOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.anagraficadisaggregazione.ListaAnagraficaDisaggregazioneOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisaggregazioneManagerBL extends AbstractBL {

	@Autowired
	private AnagDisaggregazioneRESTClient anagDisaggregazioneRestClient;
	
	//R1I_20_0131
	public GenericListBean<AnagraficaDisaggregazioneOutputBean> getAnagraficaDisaggregazione(String codificaOloAgcom, String tipoProfilo, String sezione) throws BusinessLayerException {
				GenericListBean<AnagraficaDisaggregazioneOutputBean> list = new GenericListBean<>();
				try {
					//R1I_20_0131
					ListaAnagraficaDisaggregazioneOutputDTO dto = anagDisaggregazioneRestClient.getAnagraficaDisaggregazione(codificaOloAgcom, tipoProfilo, sezione);
					list.setData(mapper.translateList(dto.getListaDisaggregazione(), AnagraficaDisaggregazioneOutputBean.class));
				} catch (Exception e) {
					throw new BusinessLayerException(e);
				}
				return list;
			}
	

}
