package br.com.valmirjunior.gradbook.control.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.valmirjunior.gradbook.model.Discipline;
import br.com.valmirjunior.gradbook.model.dao.GenericDao;

@FacesConverter(forClass=Discipline.class)
public class DisciplineConverter implements Converter {

	private GenericDao genericDao;

	public DisciplineConverter() {
		try {
			this.genericDao = (GenericDao) new InitialContext().lookup("java:global/GradBook/GenericDao");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {		
		if (value != "") {
			return genericDao.getById(Discipline.class,Integer.parseInt(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {		
		if (value != null){
			return ((Discipline) value).getId() + "";
		}
		return null;
	}

}
