package com.nttdata.tim.now.core.comparators;

import java.util.Comparator;

import com.nttdata.tim.now.data.dto.news.NewsDTO;

public class NewsComparator implements Comparator<NewsDTO> {
	@Override
	public int compare(NewsDTO o1, NewsDTO o2) {
		return o2.getDateInserimento().compareTo(o1.getDateInserimento());
	}
}
