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
 * UtLocation
 */
@Entity
@Table(name = "UT_LOCATION")
public class UtLocation implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The location id. */
	private Long locationId;
	
	/** The ut partner. */
	private UtPartner locationUtPartner;
	
	/** The location name. */
	private String locationName;
	
	/** The location description. */
	private String locationDescription;
	
	/** The location active. */
	private Boolean locationActive;
	
	/** The sys modification timestamp. */
	private Timestamp locationModifTime;
	
	/** The sys modification user. */
	private ApnaUser locationModifUser;

	/**
	 * Instantiates a new ut location.
	 */
	public UtLocation() {
	}

	/**
	 * Instantiates a new ut location.
	 *
	 * @param locationId the location id
	 * @param locationName the location name
	 * @param locationActive the location active
	 * @param locationModifTime the location modif time
	 * @param locationModifUser the location modif user
	 */
	public UtLocation(Long locationId, String locationName, Boolean locationActive,
			Timestamp locationModifTime, ApnaUser locationModifUser) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationActive = locationActive;
		this.locationModifTime = locationModifTime;
		this.locationModifUser = locationModifUser;
	}

	/**
	 * Instantiates a new ut location.
	 *
	 * @param locationId the location id
	 * @param locationUtPartner the location ut partner
	 * @param locationName the location name
	 * @param locationDescription the location description
	 * @param locationActive the location active
	 * @param locationModifTime the location modif time
	 * @param locationModifUser the location modif user
	 */
	public UtLocation(Long locationId, UtPartner locationUtPartner, String locationName, String locationDescription,
			Boolean locationActive, Timestamp locationModifTime, ApnaUser locationModifUser) {
		this.locationId = locationId;
		this.locationUtPartner = locationUtPartner;
		this.locationName = locationName;
		this.locationDescription = locationDescription;
		this.locationActive = locationActive;
		this.locationModifTime = locationModifTime;
		this.locationModifUser = locationModifUser;
	}

	/**
	 * Gets the location id.
	 *
	 * @return the location id
	 */
	@TableGenerator(
	        name="locGen", 
	        table="ID_GEN", 
	        pkColumnName="GEN_KEY", 
	        valueColumnName="GEN_VALUE", 
	        pkColumnValue="LOCATION_ID", 
	        allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="locGen")
	@Id
	@Column(name = "LOCATION_ID", unique = true, nullable = false)
	public Long getLocationId() {
		return this.locationId;
	}

	/**
	 * Sets the location id.
	 *
	 * @param locationId the new location id
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets the location ut partner.
	 *
	 * @return the location ut partner
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_PARTNER_ID")
	public UtPartner getLocationUtPartner() {
		return locationUtPartner;
	}
	
	/**
	 * Sets the location ut partner.
	 *
	 * @param locationUtPartner the new location ut partner
	 */
	public void setLocationUtPartner(UtPartner locationUtPartner) {
		this.locationUtPartner = locationUtPartner;
	}

	/**
	 * Gets the location name.
	 *
	 * @return the location name
	 */
	@Column(name = "LOCATION_NAME", nullable = false, length = 100)
	public String getLocationName() {
		return this.locationName;
	}

	/**
	 * Sets the location name.
	 *
	 * @param locationName the new location name
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * Gets the location description.
	 *
	 * @return the location description
	 */
	@Column(name = "LOCATION_DESCRIPTION", length = 2000)
	public String getLocationDescription() {
		return this.locationDescription;
	}

	/**
	 * Sets the location description.
	 *
	 * @param locationDescription the new location description
	 */
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	/**
	 * Gets the location active.
	 *
	 * @return the location active
	 */
	@Column(name = "LOCATION_ACTIVE", nullable = false)
	@Type(type="true_false")
	public Boolean getLocationActive() {
		return this.locationActive;
	}

	/**
	 * Sets the location active.
	 *
	 * @param locationActive the new location active
	 */
	public void setLocationActive(Boolean locationActive) {
		this.locationActive = locationActive;
	}

	/**
	 * Gets the location modif time.
	 *
	 * @return the location modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getLocationModifTime() {
		return locationModifTime;
	}
	
	/**
	 * Sets the location modif time.
	 *
	 * @param locationModifTime the new location modif time
	 */
	public void setLocationModifTime(Timestamp locationModifTime) {
		this.locationModifTime = locationModifTime;
	}

	/**
	 * Gets the location modif user.
	 *
	 * @return the location modif user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getLocationModifUser() {
		return locationModifUser;
	}
	
	/**
	 * Sets the location modif user.
	 *
	 * @param locationModifUser the new location modif user
	 */
	public void setLocationModifUser(ApnaUser locationModifUser) {
		this.locationModifUser = locationModifUser;
	}
}
