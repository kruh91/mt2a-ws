package hr.optimit.hibernate.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * UtProject.
 */
@Entity
@Table(name = "UT_PROJECT")
public class UtProject implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The project id. */
	private Long projectId;

	/** The ut partner. */
	private UtPartner projectUtPartner;

	/** The project shortname. */
	private String projectShortname;

	/** The project name. */
	private String projectName;

	/** The project description. */
	private String projectDescription;

	/** The project start date. */
	private Date projectStartDate;

	/** The project end date. */
	private Date projectEndDate;

	/** The project billable. */
	private Boolean projectBillable;

	/** The sys modification timestamp. */
	private Timestamp projectModifTime;

	/** The sys modification user. */
	private ApnaUser projectModifUser;

	/** The project users. */
	private Set<ApnaUser> projectUsers = new HashSet<ApnaUser>(0);

	/**
	 * Instantiates a new ut project.
	 */
	public UtProject() {
	}

	/**
	 * Instantiates a new ut project.
	 *
	 * @param projectId
	 *            the project id
	 * @param projectShortname
	 *            the project shortname
	 * @param projectStartDate
	 *            the project start date
	 * @param projectBillable
	 *            the project billable
	 * @param projectModifTime
	 *            the project modif time
	 * @param projectModifUser
	 *            the project modif user
	 */
	public UtProject(Long projectId, String projectShortname, Date projectStartDate, Boolean projectBillable,
			Timestamp projectModifTime, ApnaUser projectModifUser) {
		this.projectId = projectId;
		this.projectShortname = projectShortname;
		this.projectStartDate = projectStartDate;
		this.projectBillable = projectBillable;
		this.projectModifTime = projectModifTime;
		this.projectModifUser = projectModifUser;
	}

	/**
	 * Instantiates a new ut project.
	 *
	 * @param projectId
	 *            the project id
	 * @param projectUtPartner
	 *            the project ut partner
	 * @param projectShortname
	 *            the project shortname
	 * @param projectName
	 *            the project name
	 * @param projectDescription
	 *            the project description
	 * @param projectStartDate
	 *            the project start date
	 * @param projectEndDate
	 *            the project end date
	 * @param projectBillable
	 *            the project billable
	 * @param projectModifTime
	 *            the project modif time
	 * @param projectModifUser
	 *            the project modif user
	 * @param projectUsers
	 *            the project users
	 */
	public UtProject(Long projectId, UtPartner projectUtPartner, String projectShortname, String projectName,
			String projectDescription, Date projectStartDate, Date projectEndDate, Boolean projectBillable,
			Timestamp projectModifTime, ApnaUser projectModifUser, Set<ApnaUser> projectUsers) {
		this.projectId = projectId;
		this.projectUtPartner = projectUtPartner;
		this.projectShortname = projectShortname;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectBillable = projectBillable;
		this.projectModifTime = projectModifTime;
		this.projectModifUser = projectModifUser;
		this.projectUsers = projectUsers;
	}

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	@TableGenerator(name = "projectGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "PROJECT_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "projectGen")
	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false)
	public Long getProjectId() {
		return this.projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId
	 *            the new project id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the project ut partner.
	 *
	 * @return the project ut partner
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_PARTNER_ID")
	public UtPartner getProjectUtPartner() {
		return projectUtPartner;
	}

	/**
	 * Sets the project ut partner.
	 *
	 * @param projectUtPartner
	 *            the new project ut partner
	 */
	public void setProjectUtPartner(UtPartner projectUtPartner) {
		this.projectUtPartner = projectUtPartner;
	}

	/**
	 * Gets the project shortname.
	 *
	 * @return the project shortname
	 */
	@Column(name = "PROJECT_SHORTNAME", nullable = false, length = 20)
	public String getProjectShortname() {
		return this.projectShortname;
	}

	/**
	 * Sets the project shortname.
	 *
	 * @param projectShortname
	 *            the new project shortname
	 */
	public void setProjectShortname(String projectShortname) {
		this.projectShortname = projectShortname;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	@Column(name = "PROJECT_NAME", length = 200)
	public String getProjectName() {
		return this.projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName
	 *            the new project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the project description.
	 *
	 * @return the project description
	 */
	@Column(name = "PROJECT_DESCRIPTION", length = 2000)
	public String getProjectDescription() {
		return this.projectDescription;
	}

	/**
	 * Sets the project description.
	 *
	 * @param projectDescription
	 *            the new project description
	 */
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * Gets the project start date.
	 *
	 * @return the project start date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROJECT_START_DATE", nullable = false, length = 21)
	public Date getProjectStartDate() {
		return this.projectStartDate;
	}

	/**
	 * Sets the project start date.
	 *
	 * @param projectStartDate
	 *            the new project start date
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * Gets the project end date.
	 *
	 * @return the project end date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROJECT_END_DATE", length = 21)
	public Date getProjectEndDate() {
		return this.projectEndDate;
	}

	/**
	 * Sets the project end date.
	 *
	 * @param projectEndDate
	 *            the new project end date
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * Gets the project billable.
	 *
	 * @return the project billable
	 */
	@Column(name = "PROJECT_BILLABLE", nullable = false)
	@Type(type = "true_false")
	public Boolean getProjectBillable() {
		return this.projectBillable;
	}

	/**
	 * Sets the project billable.
	 *
	 * @param projectBillable
	 *            the new project billable
	 */
	public void setProjectBillable(Boolean projectBillable) {
		this.projectBillable = projectBillable;
	}

	/**
	 * Gets the project modif time.
	 *
	 * @return the project modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getProjectModifTime() {
		return projectModifTime;
	}

	/**
	 * Sets the project modif time.
	 *
	 * @param projectModifTime
	 *            the new project modif time
	 */
	public void setProjectModifTime(Timestamp projectModifTime) {
		this.projectModifTime = projectModifTime;
	}

	/**
	 * Gets the project modif user.
	 *
	 * @return the project modif user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getProjectModifUser() {
		return projectModifUser;
	}

	/**
	 * Sets the project modif user.
	 *
	 * @param projectModifUser
	 *            the new project modif user
	 */
	public void setProjectModifUser(ApnaUser projectModifUser) {
		this.projectModifUser = projectModifUser;
	}

	/**
	 * Gets the project users.
	 *
	 * @return the project users
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ut_user2project", joinColumns = {
			@JoinColumn(name = "PROJECT_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", nullable = false) })
	public Set<ApnaUser> getProjectUsers() {
		return projectUsers;
	}

	/**
	 * Sets the project users.
	 *
	 * @param projectUsers
	 *            the new project users
	 */
	public void setProjectUsers(Set<ApnaUser> projectUsers) {
		this.projectUsers = projectUsers;
	}
}
