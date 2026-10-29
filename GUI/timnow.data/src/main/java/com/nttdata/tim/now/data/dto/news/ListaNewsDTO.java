package com.nttdata.tim.now.data.dto.news;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaNewsDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5334150662611533677L;
	
	@JsonProperty("ListaNewsInfoMigOutput")
	private List<NewsDTO> news;

	public List<NewsDTO> getNews() {
		return news;
	}

	public void setNews(List<NewsDTO> news) {
		this.news = news;
	}

}
