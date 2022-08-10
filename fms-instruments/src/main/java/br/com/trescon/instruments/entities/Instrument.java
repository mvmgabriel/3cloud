package br.com.trescon.instruments.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_instrument")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "DSTRBTNID", length = 45)
	private String dstrbtnId;

	@Column(name = "ISIN", length = 45)
	private String isin;

	@Column(name = "SEGMENT")
	private Integer segment;

	@Column(name = "TCKRSYMB", length = 45)
	private String tckrSymb;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "FileLoadId")
	@Column(name = "FILELOADID", length = 45)
	private Integer fileLoadId;

	@Column(name = "SECURITYCATEGORYCODE")
	private Long securityCategoryCode;

	@Column(name = "SECURITYIDPARENT")
	private Long securityIdParent;

	@Column(name = "ACTIVE")
	private Boolean active;

	@Column(name = "TRADGSTARTDT")
	private Date tradgStartDt;

	@Column(name = "CORPACTNSTARTDT")
	private Date corpActnStartDt;

	@Column(name = "SPCFCTNCD")
	private String spcfctnCd;

	@Column(name = "ACTUAL")
	private Boolean actual;

	@Column(name = "ISFIXEDINCOMEETF")
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
