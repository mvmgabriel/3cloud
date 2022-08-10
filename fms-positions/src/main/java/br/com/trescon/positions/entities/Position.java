package br.com.trescon.positions.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_position")
public class Position implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PositionId id;

	@Column(name = "UNDERLYINGSECURITYID")
	private Long instrumentId;

	@Column(name = "FINANCIALINSTRUMENTSECURITYID")
	private String financialInstrumentSecurityId;

	@Column(name = "TRADEREGISTRATIONORIGIN")
	private String tradeRegistrationOrigin;

	@Column(name = "TRADEDATE")
	private Date tradeDate;

	@Column(name = "TRADEID")
	private String tradeId;

	@Column(name = "OFFERNGNB")
	private int offerngNb;

	@Column(name = "SECURITIESFINANCINGTRADEPRVID")
	private String securitiesFinancingTradePrvId;

	@Column(name = "EXPIRYDATE")
	private Date expiryDate;

	@Column(name = "REQUESTDATE")
	private Date requestDate;

	@Column(name = "WORKINGDAYSFOREXPIRYDATE")
	private int workingDaysForExpiryDate;

	@Column(name = "MINIMUMDATEFORCALLBACK")
	private Date minimumDateForCallBack;

	@Column(name = "WORKINGDAYSFORCALLBACK")
	private int workingDaysForCallBack;

	@Column(name = "SUBACCOUNT")
	private String subAccount;

	@Column(name = "PREVIOUSDAYCLOSINGPRICE")
	private BigDecimal previousDayClosingPrice;

	@Column(name = "CURRENTFACTOR")
	private BigDecimal currentFactor;

	@Column(name = "INITIALQUANTITY")
	private BigDecimal initialQuantity;

	@Column(name = "WAITINGSETTLEMENTQUANTITY")
	private BigDecimal waitingSettlementQuantity;

	@Column(name = "SETTLEDQUANTITY")
	private BigDecimal settledQuantity;

	@Column(name = "COVEREDQUANTITY")
	private BigDecimal coveredQuantity;

	@Column(name = "CASHMARKETTRADEQUANTITY")
	private BigDecimal cashMarketTradeQuantity;

	@Column(name = "UNCOVEREDQUANTITY")
	private BigDecimal uncoveredQuantity;

	@Column(name = "RENEWALQUANTITY")
	private BigDecimal renewalQuantity;

	@Column(name = "CURRENTQUANTITY")
	private BigDecimal currentQuantity;

	@Column(name = "CURRENTVOLUMECONTRACT")
	private BigDecimal currentVolumeContract;

	@Column(name = "PAYMENTTYPE")
	private int paymentType;

	@Column(name = "EARLYCLOSINGINDICATOR")
	private boolean earlyClosingIndicator;

	@Column(name = "TENDEROFFEREARLYSETTLEMENT")
	private boolean tenderOfferEarlySettlement;

	@Column(name = "LENDERRATE")
	private BigDecimal lenderRate;

	@Column(name = "BORROWERRATE")
	private BigDecimal borrowerRate;

	@Column(name = "BORROWERFINALRATE")
	private BigDecimal borrowerFinalRate;

	@Column(name = "ANONYMITYINDICATOR")
	private Boolean anonymityIndicator;

	@Column(name = "COUNTERPARTYINTERESTOWNCAPTAX")
	private Boolean counterPartyInterestOwnCapTax;

	@Column(name = "COUNTERPARTYINCOMETAX")
	private Boolean counterPartyIncomeTax;

	@Column(name = "CONTRACTTYPE")
	private int contractType;

	@Column(name = "NETRESULTIDENTIFICATION")
	private String netResultIdentification;

	@Column(name = "REFERENCEPRICE")
	private BigDecimal referencePrice;

	@Column(name = "REQUESTEDRENEWALQUANTITY")
	private BigDecimal requestedRenewalQuantity;

	@Column(name = "REQUESTEDSETTLEDQUANTITY")	
	private BigDecimal requestedSettledQuantity;

	@Column(name = "ORIGINALQUANTITY")
	private BigDecimal originalQuantity;

	@Column(name = "SECURITIESLENDINGTYPE")
	private String securitiesLendingType;

	@Column(name = "TRADERATE")
	private BigDecimal tradeRate;

	@Column(name = "STATUSACTIVE")
	private Boolean statusActive;

	@Column(name = "FREEQUANTITY")
	private BigDecimal freeQuantity;

	@Column(name = "RENEWALCONTROLID")
	private Integer renewalControlId;

	@Column(name = "TRADEINSTRUCTIONID")
	private Integer tradeInstructionId;

	@Column(name = "TICKETCODE")
	private String ticketCode;

	public PositionId getId() {
		return id;
	}

	public void setId(PositionId id) {
		this.id = id;
	}

	public String getFinancialInstrumentSecurityId() {
		return financialInstrumentSecurityId;
	}

	public void setFinancialInstrumentSecurityId(String financialInstrumentSecurityId) {
		this.financialInstrumentSecurityId = financialInstrumentSecurityId;
	}
	
	public Long getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Long instrumentId) {
		this.instrumentId = instrumentId;
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

	public String getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}

	public BigDecimal getPreviousDayClosingPrice() {
		return previousDayClosingPrice;
	}

	public void setPreviousDayClosingPrice(BigDecimal previousDayClosingPrice) {
		this.previousDayClosingPrice = previousDayClosingPrice;
	}

	public BigDecimal getCurrentFactor() {
		return currentFactor;
	}

	public void setCurrentFactor(BigDecimal currentFactor) {
		this.currentFactor = currentFactor;
	}

	public BigDecimal getInitialQuantity() {
		return initialQuantity;
	}

	public void setInitialQuantity(BigDecimal initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	public BigDecimal getWaitingSettlementQuantity() {
		return waitingSettlementQuantity;
	}

	public void setWaitingSettlementQuantity(BigDecimal waitingSettlementQuantity) {
		this.waitingSettlementQuantity = waitingSettlementQuantity;
	}

	public BigDecimal getSettledQuantity() {
		return settledQuantity;
	}

	public void setSettledQuantity(BigDecimal settledQuantity) {
		this.settledQuantity = settledQuantity;
	}

	public BigDecimal getCoveredQuantity() {
		return coveredQuantity;
	}

	public void setCoveredQuantity(BigDecimal coveredQuantity) {
		this.coveredQuantity = coveredQuantity;
	}

	public BigDecimal getCashMarketTradeQuantity() {
		return cashMarketTradeQuantity;
	}

	public void setCashMarketTradeQuantity(BigDecimal cashMarketTradeQuantity) {
		this.cashMarketTradeQuantity = cashMarketTradeQuantity;
	}

	public BigDecimal getUncoveredQuantity() {
		return uncoveredQuantity;
	}

	public void setUncoveredQuantity(BigDecimal uncoveredQuantity) {
		this.uncoveredQuantity = uncoveredQuantity;
	}

	public BigDecimal getRenewalQuantity() {
		return renewalQuantity;
	}

	public void setRenewalQuantity(BigDecimal renewalQuantity) {
		this.renewalQuantity = renewalQuantity;
	}

	public BigDecimal getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(BigDecimal currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public BigDecimal getCurrentVolumeContract() {
		return currentVolumeContract;
	}

	public void setCurrentVolumeContract(BigDecimal currentVolumeContract) {
		this.currentVolumeContract = currentVolumeContract;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isEarlyClosingIndicator() {
		return earlyClosingIndicator;
	}

	public void setEarlyClosingIndicator(boolean earlyClosingIndicator) {
		this.earlyClosingIndicator = earlyClosingIndicator;
	}

	public boolean isTenderOfferEarlySettlement() {
		return tenderOfferEarlySettlement;
	}

	public void setTenderOfferEarlySettlement(boolean tenderOfferEarlySettlement) {
		this.tenderOfferEarlySettlement = tenderOfferEarlySettlement;
	}

	public BigDecimal getLenderRate() {
		return lenderRate;
	}

	public void setLenderRate(BigDecimal lenderRate) {
		this.lenderRate = lenderRate;
	}

	public BigDecimal getBorrowerRate() {
		return borrowerRate;
	}

	public void setBorrowerRate(BigDecimal borrowerRate) {
		this.borrowerRate = borrowerRate;
	}

	public BigDecimal getBorrowerFinalRate() {
		return borrowerFinalRate;
	}

	public void setBorrowerFinalRate(BigDecimal borrowerFinalRate) {
		this.borrowerFinalRate = borrowerFinalRate;
	}

	public Boolean getAnonymityIndicator() {
		return anonymityIndicator;
	}

	public void setAnonymityIndicator(Boolean anonymityIndicator) {
		this.anonymityIndicator = anonymityIndicator;
	}

	public Boolean getCounterPartyInterestOwnCapTax() {
		return counterPartyInterestOwnCapTax;
	}

	public void setCounterPartyInterestOwnCapTax(Boolean counterPartyInterestOwnCapTax) {
		this.counterPartyInterestOwnCapTax = counterPartyInterestOwnCapTax;
	}

	public Boolean getCounterPartyIncomeTax() {
		return counterPartyIncomeTax;
	}

	public void setCounterPartyIncomeTax(Boolean counterPartyIncomeTax) {
		this.counterPartyIncomeTax = counterPartyIncomeTax;
	}

	public int getContractType() {
		return contractType;
	}

	public void setContractType(int contractType) {
		this.contractType = contractType;
	}

	public String getNetResultIdentification() {
		return netResultIdentification;
	}

	public void setNetResultIdentification(String netResultIdentification) {
		this.netResultIdentification = netResultIdentification;
	}

	public BigDecimal getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(BigDecimal referencePrice) {
		this.referencePrice = referencePrice;
	}

	public BigDecimal getRequestedRenewalQuantity() {
		return requestedRenewalQuantity;
	}

	public void setRequestedRenewalQuantity(BigDecimal requestedRenewalQuantity) {
		this.requestedRenewalQuantity = requestedRenewalQuantity;
	}

	public BigDecimal getRequestedSettledQuantity() {
		return requestedSettledQuantity;
	}

	public void setRequestedSettledQuantity(BigDecimal requestedSettledQuantity) {
		this.requestedSettledQuantity = requestedSettledQuantity;
	}

	public BigDecimal getOriginalQuantity() {
		return originalQuantity;
	}

	public void setOriginalQuantity(BigDecimal originalQuantity) {
		this.originalQuantity = originalQuantity;
	}

	public String getSecuritiesLendingType() {
		return securitiesLendingType;
	}

	public void setSecuritiesLendingType(String securitiesLendingType) {
		this.securitiesLendingType = securitiesLendingType;
	}

	public BigDecimal getTradeRate() {
		return tradeRate;
	}

	public void setTradeRate(BigDecimal tradeRate) {
		this.tradeRate = tradeRate;
	}

	public Boolean getStatusActive() {
		return statusActive;
	}

	public void setStatusActive(Boolean statusActive) {
		this.statusActive = statusActive;
	}

	public BigDecimal getFreeQuantity() {
		return freeQuantity;
	}

	public void setFreeQuantity(BigDecimal freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	public Integer getRenewalControlId() {
		return renewalControlId;
	}

	public void setRenewalControlId(Integer renewalControlId) {
		this.renewalControlId = renewalControlId;
	}

	public Integer getTradeInstructionId() {
		return tradeInstructionId;
	}

	public void setTradeInstructionId(Integer tradeInstructionId) {
		this.tradeInstructionId = tradeInstructionId;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	/*
    private BigDecimal ticketRate;
    private BigDecimal ticketCommission;
    private BigDecimal ticketRateCounterparty;
    private BigDecimal ticketCommissionCounterparty;
    private BigDecimal recallQuantity;

    private String originalContractType;
    private String brokerDealerIdentification;
    private Boolean buySideIndicator;
    private Boolean offeringCertificateIndicator;

    private Integer contractUpdateType;
    private String transactionIdentification;

    private Integer modality;

	private BigDecimal financialValue;
    private BigDecimal oneDayCostValue;
    private String settlementReminder;

    private BigDecimal ticketBrokerage;
    private BigDecimal ticketIntervalBrokerage;

    //private TbBrokeragePlan tbBrokeragePlanByBrokeragePlanIdOriginal;
    private Date updateDateTimeOriginal;
    //private TbBrokeragePlan tbBrokeragePlanByBrokeragePlanIdCurrent;
    private Date updateDateTimeCurrent;
    private String updateLoginCurrent;

    private Boolean percentageSync;
    private int workingDaysFromTradeDate;
    private Date scheduledRenewalDate;
    private Integer workingDaysTradeToExpiryDate;
    private BigDecimal brokerageValueSimuD0;
    private BigDecimal brokerageValueSimuExpiry;

	 */


}
