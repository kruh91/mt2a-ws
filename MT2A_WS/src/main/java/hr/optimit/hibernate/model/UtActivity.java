package hr.optimit.hibernate.model;

import java.sql.Timestamp;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * UtActivity.
 */
@Entity
@Table(name = "UT_ACTIVITY")
public class UtActivity implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The activity id. */
	private Long activityId;
	
	/** The activity ut task. */
	private UtTask activityUtTask;
	
	/** The activity ut location. */
	private UtLocation activityUtLocation;
	
	/** The activity description. */
	private String activityDescription;
	
	/** The activity ref. */
	private String activityRef;
	
	/** The activity start date. */
	private Date activityStartDate;
	
	/** The activity end date. */
	private Date activityEndDate;
	
	/** The activity billable. */
	private Boolean activityBillable;
	
	/** The activity user id. */
	private ApnaUser activityUser;
	
	/** The activity modif time. */
	private Timestamp activityModifTime;
	
	/** The activity modif user. */
	private ApnaUser activityModifUser;

	/**
	 * Instantiates a new ut activity.
	 */
	public UtActivity() {
	}

	/**
	 * Instantiates a new ut activity.
	 *
	 * @param activityId the activity id
	 * @param activityUtTask the activity ut task
	 * @param activityUtLocation the activity ut location
	 * @param activityStartDate the activity start date
	 * @param activityEndDate the activity end date
	 * @param activityBillable the activity billable
	 * @param activityUser the activity user
	 * @param activityModifTime the activity modif time
	 * @param activityModifUser the activity modif user
	 */
	public UtActivity(Long activityId, UtTask activityUtTask, UtLocation activityUtLocation, Date activityStartDate,
			Date activityEndDate, Boolean activityBillable, ApnaUser activityUser,
			Timestamp activityModifTime, ApnaUser activityModifUser) {
		this.activityId = activityId;
		this.activityUtTask = activityUtTask;
		this.activityUtLocation = activityUtLocation;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.activityBillable = activityBillable;
		this.activityUser = activityUser;
		this.activityModifTime = activityModifTime;
		this.activityModifUser = activityModifUser;
	}

	/**
	 * Instantiates a new ut activity.
	 *
	 * @param activityId the activity id
	 * @param activityUtTask the activity ut task
	 * @param activityUtLocation the activity ut location
	 * @param activityDescription the activity description
	 * @param activityRef the activity ref
	 * @param activityStartDate the activity start date
	 * @param activityEndDate the activity end date
	 * @param activityBillable the activity billable
	 * @param activityUser the activity user
	 * @param activityModifTime the activity modif time
	 * @param activityModifUser the activity modif user
	 */
	public UtActivity(Long activityId, UtTask activityUtTask, UtLocation activityUtLocation, String activityDescription,
			String activityRef, Date activityStartDate, Date activityEndDate, Boolean activityBillable,
			ApnaUser activityUser, Timestamp activityModifTime, ApnaUser activityModifUser) {
		this.activityId = activityId;
		this.activityUtTask = activityUtTask;
		this.activityUtLocation = activityUtLocation;
		this.activityDescription = activityDescription;
		this.activityRef = activityRef;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.activityBillable = activityBillable;
		this.activityUser = activityUser;
		this.activityModifTime = activityModifTime;
		this.activityModifUser = activityModifUser;
	}

	/**
	 * Gets the activity id.
	 *
	 * @return the activity id
	 */
	@TableGenerator(
	        name="actGen", 
	        table="ID_GEN", 
	        pkColumnName="GEN_KEY", 
	        valueColumnName="GEN_VALUE", 
	        pkColumnValue="ACIVITY_ID", 
	        allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actGen")
	@Id
	@Column(name = "ACTIVITY_ID", unique = true, nullable = false)
	public Long getActivityId() {
		return this.activityId;
	}

	/**
	 * Sets the activity id.
	 *
	 * @param activityId the new activity id
	 */
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	/**
	 * Gets the activity ut task.
	 *
	 * @return the activity ut task
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_TASK_ID", nullable = false)
	public UtTask getActivityUtTask() {
		return activityUtTask;
	}
	
	/**
	 * Sets the activity ut task.
	 *
	 * @param activityUtTask the new activity ut task
	 */
	public void setActivityUtTask(UtTask activityUtTask) {
		this.activityUtTask = activityUtTask; 
	}

	/**
	 * Gets the activity ut location.
	 *
	 * @return the activity ut location
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_LOCATION_ID", nullable = false)
	public UtLocation getActivityUtLocation() {
		return activityUtLocation;
	}
	
	/**
	 * Sets the activity ut location.
	 *
	 * @param activityUtLocation the new activity ut location
	 */
	public void setActivityUtLocation(UtLocation activityUtLocation) {
		this.activityUtLocation = activityUtLocation;
	}

	/**
	 * Gets the activity description.
	 *
	 * @return the activity description
	 */
	@Column(name = "ACTIVITY_DESCRIPTION", length = 2000)
	public String getActivityDescription() {
		return this.activityDescription;
	}

	/**
	 * Sets the activity description.
	 *
	 * @param activityDescription the new activity description
	 */
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	/**
	 * Gets the activity ref.
	 *
	 * @return the activity ref
	 */
	@Column(name = "ACTIVITY_REF", length = 20)
	public String getActivityRef() {
		return this.activityRef;
	}

	/**
	 * Sets the activity ref.
	 *
	 * @param activityRef the new activity ref
	 */
	public void setActivityRef(String activityRef) {
		this.activityRef = activityRef;
	}

	/**
	 * Gets the activity start date.
	 *
	 * @return the activity start date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTIVITY_START_DATE", nullable = false, length = 21)
	public Date getActivityStartDate() {
		return this.activityStartDate;
	}

	/**
	 * Sets the activity start date.
	 *
	 * @param activityStartDate the new activity start date
	 */
	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	/**
	 * Gets the activity end date.
	 *
	 * @return the activity end date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTIVITY_END_DATE", nullable = false, length = 21)
	public Date getActivityEndDate() {
		return this.activityEndDate;
	}

	/**
	 * Sets the activity end date.
	 *
	 * @param activityEndDate the new activity end date
	 */
	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	/**
	 * Gets the activity billable.
	 *
	 * @return the activity billable
	 */
	@Column(name = "ACTIVITY_BILLABLE", nullable = false)
	@Type(type="true_false")
	public Boolean getActivityBillable() {
		return this.activityBillable;
	}

	/**
	 * Sets the activity billable.
	 *
	 * @param activityBillable the new activity billable
	 */
	public void setActivityBillable(Boolean activityBillable) {
		this.activityBillable = activityBillable;
	}

	/**
	 * Gets the activity user.
	 *
	 * @return the activity user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_USER_ID")
	public ApnaUser getActivityUser() {
		return this.activityUser;
	}

	/**
	 * Sets the activity user.
	 *
	 * @param activityUser the new activity user
	 */
	public void setActivityUser(ApnaUser activityUser) {
		this.activityUser = activityUser;
	}

	/**
	 * Gets the activity modif time.
	 *
	 * @return the activity modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getActivityModifTime() {
		return activityModifTime;
	}
	
	/**
	 * Sets the activity modif time.
	 *
	 * @param activityModifTime the new activity modif time
	 */
	public void setActivityModifTime(Timestamp activityModifTime) {
		this.activityModifTime = activityModifTime;
	}

	/**
	 * Gets the activity modif user.
	 *
	 * @return the activity modif user
	 */
	@ManyToOne
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getActivityModifUser() {
		return activityModifUser;
	}
	
	/**
	 * Sets the activity modif user.
	 *
	 * @param activityModifUser the new activity modif user
	 */
	public void setActivityModifUser(ApnaUser activityModifUser) {
		this.activityModifUser = activityModifUser;
	}
}
