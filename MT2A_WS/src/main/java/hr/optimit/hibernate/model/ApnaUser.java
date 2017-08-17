package hr.optimit.hibernate.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 * The Class ApnaUser.
 *
 * @author tomek
 */
@Entity
@Table(name = "APNA_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_USERNAME"))
public class ApnaUser implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private Long userId;

	/** The user username. */
	private String userUsername;

	/** The user password. */
	private String userPassword;

	/** The user status. */
	private String userStatus;

	/** The user role. */
	private String userRole;

	/** The user first name. */
	private String userFirstName;

	/** The user last name. */
	private String userLastName;

	/** The user email. */
	private String userEmail;

	/** The user creation timestamp. */
	private Timestamp userCreationTimestamp;

	/** The user modif time. */
	private Timestamp userModifTime;

	/** The user modif user. */
	private ApnaUser userModifUser;

	/** The allowed domains. */
	private String allowedDomains;

	/** The user projects. */
	private Set<UtProject> userProjects = new HashSet<UtProject>(0);

	/** The user tasks. */
	private Set<UtTask> userTasks = new HashSet<UtTask>(0);

	/**
	 * Instantiates a new apna user.
	 */
	public ApnaUser() {
	}

	/**
	 * Instantiates a new apna user.
	 *
	 * @param userId
	 *            the user id
	 * @param userUsername
	 *            the user username
	 * @param userPassword
	 *            the user password
	 * @param userStatus
	 *            the user status
	 * @param userRole
	 *            the user role
	 * @param userFirstName
	 *            the user first name
	 * @param userLastName
	 *            the user last name
	 * @param userCreationTimestamp
	 *            the user creation timestamp
	 * @param userModifTime
	 *            the user modif time
	 * @param userModifUser
	 *            the user modif user
	 * @param allowedDomains
	 *            the allowed domains
	 */
	public ApnaUser(Long userId, String userUsername, String userPassword, String userStatus, String userRole,
			String userFirstName, String userLastName, Timestamp userCreationTimestamp, Timestamp userModifTime,
			ApnaUser userModifUser, String allowedDomains) {
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userRole = userRole;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userCreationTimestamp = userCreationTimestamp;
		this.userModifTime = userModifTime;
		this.userModifUser = userModifUser;
		this.allowedDomains = allowedDomains;
	}

	/**
	 * Instantiates a new apna user.
	 *
	 * @param userId
	 *            the user id
	 * @param userUsername
	 *            the user username
	 * @param userPassword
	 *            the user password
	 * @param userStatus
	 *            the user status
	 * @param userRole
	 *            the user role
	 * @param userFirstName
	 *            the user first name
	 * @param userLastName
	 *            the user last name
	 * @param userEmail
	 *            the user email
	 * @param userCreationTimestamp
	 *            the user creation timestamp
	 * @param userModifTime
	 *            the user modif time
	 * @param userModifUser
	 *            the user modif user
	 * @param allowedDomains
	 *            the allowed domains
	 * @param userProjects
	 *            the user projects
	 * @param userTasks
	 *            the user tasks
	 */
	public ApnaUser(Long userId, String userUsername, String userPassword, String userStatus, String userRole,
			String userFirstName, String userLastName, String userEmail, Timestamp userCreationTimestamp,
			Timestamp userModifTime, ApnaUser userModifUser, String allowedDomains, Set<UtProject> userProjects,
			Set<UtTask> userTasks) {
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userRole = userRole;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userCreationTimestamp = userCreationTimestamp;
		this.userModifTime = userModifTime;
		this.userModifUser = userModifUser;
		this.allowedDomains = allowedDomains;
		this.userEmail = userEmail;
		this.userProjects = userProjects;
		this.userTasks = userTasks;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	@TableGenerator(name = "userGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "USER_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "userGen")
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user username.
	 *
	 * @return the user username
	 */
	@Column(name = "USER_USERNAME", unique = true, nullable = false, length = 20)
	public String getUserUsername() {
		return this.userUsername;
	}

	/**
	 * Sets the user username.
	 *
	 * @param userUsername
	 *            the new user username
	 */
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	/**
	 * Gets the user password.
	 *
	 * @return the user password
	 */
	@Column(name = "USER_PASSWORD", nullable = false)
	public String getUserPassword() {
		return this.userPassword;
	}

	/**
	 * Sets the user password.
	 *
	 * @param userPassword
	 *            the new user password
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Gets the user status.
	 *
	 * @return the user status
	 */
	@Column(name = "USER_STATUS", nullable = false, length = 20)
	public String getUserStatus() {
		return this.userStatus;
	}

	/**
	 * Sets the user status.
	 *
	 * @param userStatus
	 *            the new user status
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	@Column(name = "USER_ROLE", nullable = false, length = 20)
	public String getUserRole() {
		return this.userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole
	 *            the new user role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Gets the user first name.
	 *
	 * @return the user first name
	 */
	@Column(name = "USER_FIRST_NAME", nullable = false, length = 30)
	public String getUserFirstName() {
		return this.userFirstName;
	}

	/**
	 * Sets the user first name.
	 *
	 * @param userFirstName
	 *            the new user first name
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * Gets the user last name.
	 *
	 * @return the user last name
	 */
	@Column(name = "USER_LAST_NAME", nullable = false, length = 30)
	public String getUserLastName() {
		return this.userLastName;
	}

	/**
	 * Sets the user last name.
	 *
	 * @param userLastName
	 *            the new user last name
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * Gets the user email.
	 *
	 * @return the user email
	 */
	@Column(name = "USER_EMAIL", length = 50)
	public String getUserEmail() {
		return this.userEmail;
	}

	/**
	 * Sets the user email.
	 *
	 * @param userEmail
	 *            the new user email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Gets the user creation timestamp.
	 *
	 * @return the user creation timestamp
	 */
	@Column(name = "USER_CREATION_TIMESTAMP", nullable = false)
	public Timestamp getUserCreationTimestamp() {
		return this.userCreationTimestamp;
	}

	/**
	 * Sets the user creation timestamp.
	 *
	 * @param userCreationTimestamp
	 *            the new user creation timestamp
	 */
	public void setUserCreationTimestamp(Timestamp userCreationTimestamp) {
		this.userCreationTimestamp = userCreationTimestamp;
	}

	/**
	 * Gets the user modif time.
	 *
	 * @return the user modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getUserModifTime() {
		return userModifTime;
	}

	/**
	 * Sets the user modif time.
	 *
	 * @param userModifTime
	 *            the new user modif time
	 */
	public void setUserModifTime(Timestamp userModifTime) {
		this.userModifTime = userModifTime;
	}

	/**
	 * Gets the user modif user.
	 *
	 * @return the user modif user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getUserModifUser() {
		return userModifUser;
	}

	/**
	 * Sets the user modif user.
	 *
	 * @param userModifUser
	 *            the new user modif user
	 */
	public void setUserModifUser(ApnaUser userModifUser) {
		this.userModifUser = userModifUser;
	}

	/**
	 * Gets the allowed domains.
	 *
	 * @return the allowed domains
	 */
	@Column(name = "ALLOWED_DOMAINS", nullable = false, length = 50)
	public String getAllowedDomains() {
		return this.allowedDomains;
	}

	/**
	 * Sets the allowed domains.
	 *
	 * @param allowedDomains
	 *            the new allowed domains
	 */
	public void setAllowedDomains(String allowedDomains) {
		this.allowedDomains = allowedDomains;
	}

	/**
	 * Gets the user projects.
	 *
	 * @return the user projects
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projectUsers")
	public Set<UtProject> getUserProjects() {
		return userProjects;
	}

	/**
	 * Sets the user projects.
	 *
	 * @param userProjects
	 *            the new user projects
	 */
	public void setUserProjects(Set<UtProject> userProjects) {
		this.userProjects = userProjects;
	}
	
	/**
	 * Gets the user tasks.
	 *
	 * @return the user tasks
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "taskUsers")
	public Set<UtTask> getUserTasks() {
		return userTasks;
	}
	
	/**
	 * Sets the user tasks.
	 *
	 * @param userTasks the new user tasks
	 */
	public void setUserTasks(Set<UtTask> userTasks) {
		this.userTasks = userTasks;
	}
}
