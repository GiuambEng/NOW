package com.nttdata.tim.now.core.comparators;

import java.util.Comparator;

import com.nttdata.tim.now.data.dto.help.HelpDTO;

public class IHelpComparator implements Comparator<HelpDTO> {
	@Override
	public int compare(HelpDTO o1, HelpDTO o2) {
		return o2.getDataInserimento().compareTo(o1.getDataInserimento());
	}
}
