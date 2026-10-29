package com.nttdata.tim.now.util.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(DozerHelper.BEAN_NAME)
public class DozerHelper {

	public static final String BEAN_NAME = "dozerHelper";

	@Autowired
	private Mapper mapper;

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	/**
	 * Esegue il mapping tra due oggetti verificando che non siano nulli.
	 * 
	 * @param source
	 * @param target
	 */
	public void translate(Object source, Object target) {
		if (source != null) {
			mapper.map(source, target);
		}
	}

	/**
	 * Costruisce una nuova istanza della destinationClass T e ed esegue il
	 * remapping con l'oggetto di input.
	 * 
	 * @param source
	 * @param destinationClass
	 * @return T 
	 */
	public <T> T translate(Object source, Class<T> destinationClass) {
		if (source != null) {
			return mapper.map(source, destinationClass);
		}
		return null;
	}

	/**
	 * Costruisce una nuova istanza di java.util.List tipizzato con la
	 * destinationClass T indicata e per ogni elemento di tipo E presente
	 * nell'oggetto di input esegue il remapping.
	 * 
	 * @param source
	 * @param elementDestinationClass
	 * @return List<T>
	 */
	public <E, T> List<T> translateList(List<E> source, Class<T> elementDestinationClass) {
		List<T> target = new ArrayList<T>();
		if (source != null) {
			for (E element : source) {
				target.add(this.translate(element, elementDestinationClass));
			}
		}
		return target;
	}
	
	/**
	 * Costruisce una nuova istanza di java.util.Set tipizzato con la
	 * destinationClass T indicata e per ogni elemento di tipo E presente
	 * nell'oggetto di input esegue il remapping.
	 * 
	 * @param source
	 * @param elementDestinationClass
	 * @return
	 */
	public <E, T> List<T> translateSetToList(Set<E> source, Class<T> elementDestinationClass) {
		List<T> target = new ArrayList<T>();
		if (source != null) {
			for (E element : source) {
				target.add(this.translate(element, elementDestinationClass));
			}
		}
		return target;
	}

	/**
	 * Costruisce una nuova istanza di java.util.Set tipizzato con la
	 * destinationClass T indicata e per ogni elemento di tipo E presente
	 * nell'oggetto di input esegue il remapping.
	 * 
	 * @param source
	 * @param elementDestinationClass
	 * @return Set<T>
	 */
	public <E, T> Set<T> translateListToSet(List<E> source, Class<T> elementDestinationClass) {
		Set<T> target = new HashSet<T>();
		if (source != null) {
			for (E element : source) {
				target.add(this.translate(element, elementDestinationClass));
			}
		}
		return target;
	}

	/**
	 * Costruisce una nuova istanza di java.util.List tipizzato con la
	 * destinationClass T indicata e per ogni elemento presente
	 * nell'oggetto di input esegue il remapping.
	 * 
	 * @param source
	 * @param elementDestinationClass
	 * @return List<T>
	 */
	public <E, T> List<T> translateArrayToList(E[] source, Class<T> elementDestinationClass) {
		List<T> target = new ArrayList<T>();
		if (source != null) {
			for (E element : source) {
				target.add(this.translate(element, elementDestinationClass));
			}
		}
		return target;
	}

}
