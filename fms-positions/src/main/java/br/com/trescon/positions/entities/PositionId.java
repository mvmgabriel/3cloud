package br.com.trescon.positions.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PositionId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "SECURITIESFINANCINGTRADEID", nullable = false, length = 35)
	private String securitiesFinancingTradeId;

	@Column(name = "SIDE", nullable = false)
	private int side;

	public PositionId() {
	}

	public PositionId(String securitiesFinancingTradeId, int side) {
		super();
		this.securitiesFinancingTradeId = securitiesFinancingTradeId;
		this.side = side;
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

}
