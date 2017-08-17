package hr.optimit.hibernate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 * UtPartner
 */
@Entity
@Table(name = "UT_PARTNER")
public class UtPartner implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The partner id. */
	private Long partnerId;

	/** The partner shortname. */
	private String partnerShortname;

	/** The partner name. */
	private String partnerName;

	/** The partner active. */
	private Boolean partnerActive;

	/** The partner modif time. */
	private Timestamp partnerModifTime;

	/** The partner modif user. */
	private ApnaUser partnerModifUser;

	/**
	 * Instantiates a new ut partner.
	 */
	public UtPartner() {
	}

	/**
	 * Instantiates a new ut partner.
	 *
	 * @param partnerId the partner id
	 * @param partnerShortname the partner shortname
	 * @param partnerName the partner name
	 * @param partnerActive the partner active
	 * @param partnerModifTime the partner modif time
	 * @param partnerModifUser the partner modif user
	 */
	public UtPartner(Long partnerId, String partnerShortname, String partnerName, Boolean partnerActive,
			Timestamp partnerModifTime, ApnaUser partnerModifUser) {
		this.partnerId = partnerId;
		this.partnerShortname = partnerShortname;
		this.partnerName = partnerName;
		this.partnerActive = partnerActive;
		this.partnerModifTime = partnerModifTime;
		this.partnerModifUser = partnerModifUser;
	}

	/**
	 * Gets the partner id.
	 *
	 * @return the partner id
	 */
	@TableGenerator(
	        name="partnerGen", 
	        table="ID_GEN", 
	        pkColumnName="GEN_KEY", 
	        valueColumnName="GEN_VALUE", 
	        pkColumnValue="PARTNER_ID", 
	        allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="partnerGen")
	@Id
	@Column(name = "PARTNER_ID", unique = true, nullable = false)
	public Long getPartnerId() {
		return this.partnerId;
	}

	/**
	 * Sets the partner id.
	 *
	 * @param partnerId
	 *            the new partner id
	 */
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * Gets the partner shortname.
	 *
	 * @return the partner shortname
	 */
	@Column(name = "PARTNER_SHORTNAME", nullable = false, length = 20)
	public String getPartnerShortname() {
		return this.partnerShortname;
	}

	/**
	 * Sets the partner shortname.
	 *
	 * @param partnerShortname
	 *            the new partner shortname
	 */
	public void setPartnerShortname(String partnerShortname) {
		this.partnerShortname = partnerShortname;
	}

	/**
	 * Gets the partner name.
	 *
	 * @return the partner name
	 */
	@Column(name = "PARTNER_NAME", nullable = false, length = 200)
	public String getPartnerName() {
		return this.partnerName;
	}

	/**
	 * Sets the partner name.
	 *
	 * @param partnerName
	 *            the new partner name
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	/**
	 * Gets the partner active.
	 *
	 * @return the partner active
	 */
	@Column(name = "PARTNER_ACTIVE", nullable = false)
	@Type(type = "true_false")
	public Boolean getPartnerActive() {
		return this.partnerActive;
	}

	/**
	 * Sets the partner active.
	 *
	 * @param partnerActive
	 *            the new partner active
	 */
	public void setPartnerActive(Boolean partnerActive) {
		this.partnerActive = partnerActive;
	}

	/**
	 * Gets the partner modif time.
	 *
	 * @return the partner modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getPartnerModifTime() {
		return partnerModifTime;
	}

	/**
	 * Sets the partner modif time.
	 *
	 * @param partnerModifTime the new partner modif time
	 */
	public void setPartnerModifTime(Timestamp partnerModifTime) {
		this.partnerModifTime = partnerModifTime;
	}

	/**
	 * Gets the sys modification user.
	 *
	 * @return the sys modification user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getPartnerModifUser() {
		return partnerModifUser;
	}

	/**
	 * Sets the partner modif user.
	 *
	 * @param partnerModifUser the new partner modif user
	 */
	public void setPartnerModifUser(ApnaUser partnerModifUser) {
		this.partnerModifUser = partnerModifUser;
	}
}
