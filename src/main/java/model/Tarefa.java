package model;

import java.sql.Date;

public class Tarefa {
	private int id;
	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private Date dataConclusao;
	private String status;
	private int idUsuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "Tarefas [titulo=" + titulo + ", descricao=" + descricao + ", data_criacao=" + dataCriacao
				+ ", data_conclusao=" + dataConclusao + ", status=" + status + ", idUsuario=" + idUsuario + "]";
	}
	
}
