package br.com.trescon.fmes.partacct.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.trescon.fmes.partacct.enums.ParticipantRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "tb_participant", catalog = "fms_cdc_db")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TbParticipant implements java.io.Serializable {

    private static final long serialVersionUID = 5956202185039863243L;

    private static final String[] IGNORE_FIELDS = {
		"name",
		"alias",
		"channelDefault",
		"operationType",
		"tbParticipantContacts"
	};
    
    //@Column(name = "Bvmfcode", nullable = false, length = 35)
    private String bvmfcode;

    private ParticipantRoleEnum participantRoleEnum;
    
    //@Column(name = "Name", length = 128)
    private String name;
    
    //@Column(name = "Alias", length = 64)
    private String alias;
    
    //@Column(name = "ChannelDefault")
    private Integer channelDefault;
    
    //@Column(name = "OperationType")
    private Integer operationType;
    
    @Override
	public boolean equals(Object object) {
		return EqualsBuilder.reflectionEquals(this, object, IGNORE_FIELDS);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, IGNORE_FIELDS);
	}
	
}
