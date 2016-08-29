package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.Discipline;
import br.com.valmirjunior.gradbook.model.dao.DisciplineDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "disciplineBean")
@ViewScoped
public class DisciplineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1953839273570424477L;

	@EJB
	private DisciplineDao disciplineDao;
	private Discipline discipline;
	private List<Discipline> disciplines;	

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public List<Discipline> getDisciplines() {
		if (this.disciplines == null) {
			this.disciplines = this.disciplineDao.getList();
		}
		return disciplines;
	}	

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}	


	public void create() {
		this.disciplineDao.merge(this.discipline);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.disciplineDao.merge(this.discipline);
		this.setDiscipline(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Discipline discipline) {
		this.disciplineDao.remove(discipline);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setDiscipline(new Discipline());
		this.setDisciplines(null);
	}

}