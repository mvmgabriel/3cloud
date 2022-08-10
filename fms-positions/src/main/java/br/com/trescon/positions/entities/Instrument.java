package br.com.trescon.positions.entities;

import java.io.Serializable;
import java.util.Date;

public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String dstrbtnId;
	private String isin;
	private Integer segment;
	private String tckrSymb;
	private Integer fileLoadId;
	private Long securityCategoryCode;
	private Long securityIdParent;
	private Boolean active;
	private Date tradgStartDt;
	private Date corpActnStartDt;
	private String spcfctnCd;
	private Boolean actual;
	private Boolean isFixedIncomeETF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDstrbtnId() {
		return dstrbtnId;
	}

	public void setDstrbtnId(String dstrbtnId) {
		this.dstrbtnId = dstrbtnId;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Integer getSegment() {
		return segment;
	}

	public void setSegment(Integer segment) {
		this.segment = segment;
	}

	public String getTckrSymb() {
		return tckrSymb;
	}

	public void setTckrSymb(String tckrSymb) {
		this.tckrSymb = tckrSymb;
	}

	public Integer getFileLoadId() {
		return fileLoadId;
	}

	public void setFileLoadId(Integer fileLoadId) {
		this.fileLoadId = fileLoadId;
	}

	public Long getSecurityCategoryCode() {
		return securityCategoryCode;
	}

	public void setSecurityCategoryCode(Long securityCategoryCode) {
		this.securityCategoryCode = securityCategoryCode;
	}

	public Long getSecurityIdParent() {
		return securityIdParent;
	}

	public void setSecurityIdParent(Long securityIdParent) {
		this.securityIdParent = securityIdParent;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getTradgStartDt() {
		return tradgStartDt;
	}

	public void setTradgStartDt(Date tradgStartDt) {
		this.tradgStartDt = tradgStartDt;
	}

	public Date getCorpActnStartDt() {
		return corpActnStartDt;
	}

	public void setCorpActnStartDt(Date corpActnStartDt) {
		this.corpActnStartDt = corpActnStartDt;
	}

	public String getSpcfctnCd() {
		return spcfctnCd;
	}

	public void setSpcfctnCd(String spcfctnCd) {
		this.spcfctnCd = spcfctnCd;
	}

	public Boolean getActual() {
		return actual;
	}

	public void setActual(Boolean actual) {
		this.actual = actual;
	}

	public Boolean getIsFixedIncomeETF() {
		return isFixedIncomeETF;
	}

	public void setIsFixedIncomeETF(Boolean isFixedIncomeETF) {
		this.isFixedIncomeETF = isFixedIncomeETF;
	}

}