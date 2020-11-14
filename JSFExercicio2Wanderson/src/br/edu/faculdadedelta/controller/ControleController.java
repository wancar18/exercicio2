package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.ControleDAO;
import br.edu.faculdadedelta.modelo.ControleWanderson;

@ManagedBean
@SessionScoped
public class ControleController {

	private ControleWanderson controle = new ControleWanderson();
	private ControleDAO dao = new ControleDAO();

	public ControleWanderson getControle() {
		return controle;
	}

	public void setControle(ControleWanderson controle) {
		this.controle = controle;
	}

	public void limparCampos() {
		controle = new ControleWanderson();
	}

	public String salvar() {

		try {
			if (controle.getId() == null) {
				dao.incluir(controle);
				FacesMessage mensagem = new FacesMessage("Inclusão realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparCampos();
			} else {
				dao.alterar(controle);
				FacesMessage mensagem = new FacesMessage("Alteração realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparCampos();
			}

		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage(
					"Erro ao realizar a operação. " + "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "cadastro.xhtml";
	}

	public List<ControleWanderson> getLista() {
		List<ControleWanderson> listaRetorno = new ArrayList<ControleWanderson>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage(
					"Erro ao realizar a operação. " + "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public String editar() {
		return "cadastro.xhtml";
	}

	public String excluir() {

		try {
			dao.excluir(controle);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com Sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparCampos();

		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage(
					"Erro ao realizar a operação. " + "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "cadastro.xhtml";
	}

}
