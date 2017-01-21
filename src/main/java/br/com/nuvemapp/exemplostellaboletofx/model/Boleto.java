package br.com.nuvemapp.exemplostellaboletofx.model;

public class Boleto {

	private String nomePagador; 
	private String documentoPagador; 
	private String logradouroPagador; 
	private String bairroPagador;
	private String cepPagador;
	private String cidadePagador;
	private String ufPagador;
	private String valorBoleto; 
	private int diaVencimento;
	private int mesVencimento; 
	private int anoVencimento;
	
	
	public String getNomePagador() {
		return nomePagador;
	}
	public void setNomePagador(String nomePagador) {
		this.nomePagador = nomePagador;
	}
	
	public String getDocumentoPagador() {
		return documentoPagador;
	}
	public void setDocumentoPagador(String documentoPagador) {
		this.documentoPagador = documentoPagador;
	}
	
	public String getLogradouroPagador() {
		return logradouroPagador;
	}
	public void setLogradouroPagador(String logradouroPagador) {
		this.logradouroPagador = logradouroPagador;
	}
	
	public String getBairroPagador() {
		return bairroPagador;
	}
	public void setBairroPagador(String bairroPagador) {
		this.bairroPagador = bairroPagador;
	}
	
	public String getCepPagador() {
		return cepPagador;
	}
	public void setCepPagador(String cepPagador) {
		this.cepPagador = cepPagador;
	}
	
	public String getCidadePagador() {
		return cidadePagador;
	}
	public void setCidadePagador(String cidadePagador) {
		this.cidadePagador = cidadePagador;
	}
	
	public String getUfPagador() {
		return ufPagador;
	}
	public void setUfPagador(String ufPagador) {
		this.ufPagador = ufPagador;
	}
	
	public String getValorBoleto() {
		return valorBoleto;
	}
	public void setValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
	}
	
	public int getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	
	public int getMesVencimento() {
		return mesVencimento;
	}
	public void setMesVencimento(int mesVencimento) {
		this.mesVencimento = mesVencimento;
	}
	
	public int getAnoVencimento() {
		return anoVencimento;
	}
	public void setAnoVencimento(int anoVencimento) {
		this.anoVencimento = anoVencimento;
	}
	
}