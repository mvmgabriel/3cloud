package br.com.trescon.positions.dto;

import java.util.Date;

import br.com.trescon.positions.entities.Instrument;
import br.com.trescon.positions.entities.Position;

public class PositionSimpleDto {
	
	private String securitiesFinancingTradeId;
	private int side;
	private Instrument instrument;
	private String financialInstrumentSecurityId;
	private String tradeRegistrationOrigin;
	private Date tradeDate;
	private String tradeId;
	private int offerngNb;
	private String securitiesFinancingTradePrvId;
	private Date expiryDate;
	private Date requestDate;
	private int workingDaysForExpiryDate;
	private Date minimumDateForCallBack;
	private int workingDaysForCallBack;
	
	public PositionSimpleDto() {
	}
	
	public PositionSimpleDto(Position position, Instrument instrument) {
		this.securitiesFinancingTradeId = position.getId().getSecuritiesFinancingTradeId();
		this.side = position.getId().getSide();
		this.financialInstrumentSecurityId = position.getFinancialInstrumentSecurityId();
		this.tradeRegistrationOrigin = position.getTradeRegistrationOrigin();
		this.tradeDate = position.getTradeDate();
		this.tradeId = position.getTradeId();
		this.offerngNb = position.getOfferngNb();
		this.securitiesFinancingTradePrvId = position.getSecuritiesFinancingTradePrvId();
		this.expiryDate = position.getExpiryDate();
		this.requestDate = position.getRequestDate();
		this.workingDaysForExpiryDate = position.getWorkingDaysForExpiryDate();
		this.minimumDateForCallBack = position.getMinimumDateForCallBack();
		this.workingDaysForCallBack = position.getWorkingDaysForCallBack();
		this.instrument = instrument;
	}
	
	
	public String getSecuritiesFinancingTradeId() {
		return securitiesFinancingTradeId;
	}
	public void setSecuritiesFinancingTradeId(String securitiesFinancingTradeId) {
		this.securitiesFinancingTradeId = securitiesFinancingTradeId;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public String getFinancialInstrumentSecurityId() {
		return financialInstrumentSecurityId;
	}
	public void setFinancialInstrumentSecurityId(String financialInstrumentSecurityId) {
		this.financialInstrumentSecurityId = financialInstrumentSecurityId;
	}
	public String getTradeRegistrationOrigin() {
		return tradeRegistrationOrigin;
	}
	public void setTradeRegistrationOrigin(String tradeRegistrationOrigin) {
		this.tradeRegistrationOrigin = tradeRegistrationOrigin;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getOfferngNb() {
		return offerngNb;
	}
	public void setOfferngNb(int offerngNb) {
		this.offerngNb = offerngNb;
	}
	public String getSecuritiesFinancingTradePrvId() {
		return securitiesFinancingTradePrvId;
	}
	public void setSecuritiesFinancingTradePrvId(String securitiesFinancingTradePrvId) {
		this.securitiesFinancingTradePrvId = securitiesFinancingTradePrvId;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public int getWorkingDaysForExpiryDate() {
		return workingDaysForExpiryDate;
	}
	public void setWorkingDaysForExpiryDate(int workingDaysForExpiryDate) {
		this.workingDaysForExpiryDate = workingDaysForExpiryDate;
	}
	public Date getMinimumDateForCallBack() {
		return minimumDateForCallBack;
	}
	public void setMinimumDateForCallBack(Date minimumDateForCallBack) {
		this.minimumDateForCallBack = minimumDateForCallBack;
	}
	public int getWorkingDaysForCallBack() {
		return workingDaysForCallBack;
	}
	public void setWorkingDaysForCallBack(int workingDaysForCallBack) {
		this.workingDaysForCallBack = workingDaysForCallBack;
	}
}
