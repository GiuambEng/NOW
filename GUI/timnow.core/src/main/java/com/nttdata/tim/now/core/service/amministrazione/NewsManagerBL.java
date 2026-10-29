package com.nttdata.tim.now.core.service.amministrazione;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.nttdata.tim.now.adapters.esb.amministrazione.NewsRESTClient;
import com.nttdata.tim.now.core.comparators.NewsComparator;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.news.NewsBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.news.ListaNewsDTO;
import com.nttdata.tim.now.data.dto.news.NewsDTO;
import com.nttdata.tim.now.util.FlagHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsManagerBL extends AbstractBL {

    @Autowired
    private NewsRESTClient newsRestIL;

    public GenericListBean<NewsBean> getNews(boolean onlyVisible, String profilo) throws BusinessLayerException {
        GenericListBean<NewsBean> bean = new GenericListBean<>();
        try {
            ListaNewsDTO dto = newsRestIL.getNews(profilo);
            validateResponseResult(dto);
            List<NewsDTO> news = dto.getNews();

            List<NewsBean> list = new ArrayList<>();

            if (news != null) {
                Collections.sort(news, new NewsComparator());

                for (NewsDTO element : news) {
                    if (!onlyVisible || FlagHelper.convertFromBE(element.getFlagVisibilita())) {
                        list.add(mapper.translate(element, NewsBean.class));
                    }
                }
            }
            bean.setData(list);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }


    public GenericListBean<NewsBean> createUpdateNews(NewsBean news, UserBean user) throws BusinessLayerException {
        GenericListBean<NewsBean> bean = new GenericListBean<>();
        try {
            NewsDTO inputDto = mapper.translate(news, NewsDTO.class);
            Date today = Calendar.getInstance().getTime();
            Locale.setDefault(Locale.ENGLISH);
        	if (news.getOperationType()!=null && "UPDATE".equals(news.getOperationType().toUpperCase())){
                inputDto.setDateUltimaModifica(today);
                inputDto.setOperatoreUltimaModifica(user.getUserId());
                ListaNewsDTO outputDto = newsRestIL.updateNews(inputDto, user.getCodiceProfilo());
                validateResponseResult(outputDto);
                bean.setData(mapper.translateList(outputDto.getNews(), NewsBean.class));
        	}else{
              inputDto.setDateInserimento(today);
              inputDto.setDateUltimaModifica(today);
              inputDto.setOperatore(user.getUserId());
              inputDto.setOperatoreUltimaModifica(user.getUserId());
              ListaNewsDTO outputDto = newsRestIL.createNews(inputDto, user.getCodiceProfilo());
              validateResponseResult(outputDto);
              bean.setData(mapper.translateList(outputDto.getNews(), NewsBean.class));
        	}
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<NewsBean> deleteNews(String idNews, String profilo) throws BusinessLayerException {
        GenericListBean<NewsBean> bean = new GenericListBean<>();
        try {
            ListaNewsDTO dto = newsRestIL.deleteNews(idNews, profilo);
            validateResponseResult(dto);
            bean.setData(mapper.translateList(dto.getNews(), NewsBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
