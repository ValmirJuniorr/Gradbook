package br.com.ifce.juazeiro.control.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ifce.juazeiro.model.Semester;
import br.com.ifce.juazeiro.model.dao.GenericDao;

@FacesConverter(forClass = Semester.class)
public class SemesterConverter implements Converter {

	private GenericDao genericDao;

	public SemesterConverter() {
		try {
			this.genericDao = (GenericDao) new InitialContext().lookup("java:global/GradBook/GenericDao");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != "") {
			return genericDao.getById(Semester.class, Integer.parseInt(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Semester) value).getId() + "";
		}
		return null;
	}

}