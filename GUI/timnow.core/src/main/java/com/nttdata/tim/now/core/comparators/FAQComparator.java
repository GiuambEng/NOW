package com.nttdata.tim.now.core.comparators;

import java.util.Comparator;

import com.nttdata.tim.now.data.dto.faq.FaqDTO;

public class FAQComparator implements Comparator<FaqDTO> {
	@Override
	public int compare(FaqDTO o1, FaqDTO o2) {
		return o2.getDataInserimento().compareTo(o1.getDataInserimento());
	}
}
