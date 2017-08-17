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
 * UtTask.
 */
@Entity
@Table(name = "UT_TASK")
public class UtTask implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The task id. */
	private Long taskId;
	
	/** The ut project. */
	private UtProject taskUtProject;
	
	/** The task name. */
	private String taskName;
	
	/** The task description. */
	private String taskDescription;
	
	/** The task ref. */
	private String taskRef;
	
	/** The task start date. */
	private Date taskStartDate;
	
	/** The task end date. */
	private Date taskEndDate;
	
	/** The task billable. */
	private Boolean taskBillable;
	
	/** The sys modification timestamp. */
	private Timestamp taskModifTime;
	
	/** The sys modification user. */
	private ApnaUser taskModifUser;
	
	/** The task users. */
	private Set<ApnaUser> taskUsers = new HashSet<ApnaUser>(0);

	
	/**
	 * Instantiates a new ut task.
	 */
	public UtTask() {
	}

	/**
	 * Instantiates a new ut task.
	 *
	 * @param taskId the task id
	 * @param taskUtProject the ut project
	 * @param taskName the task name
	 * @param taskStartDate the task start date
	 * @param taskBillable the task billable
	 * @param taskModifTime the task modif time
	 * @param taskModifUser the task modif user
	 */
	public UtTask(Long taskId, UtProject taskUtProject, String taskName, Date taskStartDate, Boolean taskBillable,
			Timestamp taskModifTime, ApnaUser taskModifUser) {
		this.taskId = taskId;
		this.taskUtProject = taskUtProject;
		this.taskName = taskName;
		this.taskStartDate = taskStartDate;
		this.taskBillable = taskBillable;
		this.taskModifTime = taskModifTime;
		this.taskModifUser = taskModifUser;
	}

	/**
	 * Instantiates a new ut task.
	 *
	 * @param taskId the task id
	 * @param taskUtProject the ut project
	 * @param taskName the task name
	 * @param taskDescription the task description
	 * @param taskRef the task ref
	 * @param taskStartDate the task start date
	 * @param taskEndDate the task end date
	 * @param taskBillable the task billable
	 * @param taskModifTime the task modif time
	 * @param taskModifUser the task modif user
	 * @param taskUsers the task users
	 */
	public UtTask(Long taskId, UtProject taskUtProject, String taskName, String taskDescription, String taskRef,
			Date taskStartDate, Date taskEndDate, Boolean taskBillable, Timestamp taskModifTime,
			ApnaUser taskModifUser, Set<ApnaUser> taskUsers) {
		this.taskId = taskId;
		this.taskUtProject = taskUtProject;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskRef = taskRef;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.taskBillable = taskBillable;
		this.taskModifTime = taskModifTime;
		this.taskModifUser = taskModifUser;
		this.taskUsers = taskUsers;
	}

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	@TableGenerator(
	        name="taskGen", 
	        table="ID_GEN", 
	        pkColumnName="GEN_KEY", 
	        valueColumnName="GEN_VALUE", 
	        pkColumnValue="TASK_ID", 
	        allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="taskGen")
	@Id
	@Column(name = "TASK_ID", unique = true, nullable = false)
	public Long getTaskId() {
		return this.taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the task ut project.
	 *
	 * @return the task ut project
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_PROJECT_ID", nullable = false)
	public UtProject getTaskUtProject() {
		return taskUtProject;
	}
	
	/**
	 * Sets the task ut project.
	 *
	 * @param taskUtProject the new task ut project
	 */
	public void setTaskUtProject(UtProject taskUtProject) {
		this.taskUtProject = taskUtProject;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	@Column(name = "TASK_NAME", nullable = false, length = 100)
	public String getTaskName() {
		return this.taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the task description.
	 *
	 * @return the task description
	 */
	@Column(name = "TASK_DESCRIPTION", length = 2000)
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Sets the task description.
	 *
	 * @param taskDescription the new task description
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Gets the task ref.
	 *
	 * @return the task ref
	 */
	@Column(name = "TASK_REF", length = 20)
	public String getTaskRef() {
		return this.taskRef;
	}

	/**
	 * Sets the task ref.
	 *
	 * @param taskRef the new task ref
	 */
	public void setTaskRef(String taskRef) {
		this.taskRef = taskRef;
	}

	/**
	 * Gets the task start date.
	 *
	 * @return the task start date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TASK_START_DATE", nullable = false, length = 21)
	public Date getTaskStartDate() {
		return this.taskStartDate;
	}

	/**
	 * Sets the task start date.
	 *
	 * @param taskStartDate the new task start date
	 */
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	/**
	 * Gets the task end date.
	 *
	 * @return the task end date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TASK_END_DATE", length = 21)
	public Date getTaskEndDate() {
		return this.taskEndDate;
	}

	/**
	 * Sets the task end date.
	 *
	 * @param taskEndDate the new task end date
	 */
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	/**
	 * Gets the task billable.
	 *
	 * @return the task billable
	 */
	@Column(name = "TASK_BILLABLE", nullable = false)
	@Type(type="true_false")
	public Boolean getTaskBillable() {
		return this.taskBillable;
	}

	/**
	 * Sets the task billable.
	 *
	 * @param taskBillable the new task billable
	 */
	public void setTaskBillable(Boolean taskBillable) {
		this.taskBillable = taskBillable;
	}

	/**
	 * Gets the task modif time.
	 *
	 * @return the task modif time
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getTaskModifTime() {
		return taskModifTime;
	}
	
	/**
	 * Sets the task modif time.
	 *
	 * @param taskModifTime the new task modif time
	 */
	public void setTaskModifTime(Timestamp taskModifTime) {
		this.taskModifTime = taskModifTime;
	}

	/**
	 * Gets the task modif user.
	 *
	 * @return the task modif user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_MODIFICATION_USER", nullable = false)
	public ApnaUser getTaskModifUser() {
		return taskModifUser;
	}
	
	/**
	 * Sets the task modif user.
	 *
	 * @param taskModifUser the new task modif user
	 */
	public void setTaskModifUser(ApnaUser taskModifUser) {
		this.taskModifUser = taskModifUser;
	}
	
	/**
	 * Gets the task users.
	 *
	 * @return the task users
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ut_user2task", joinColumns = {
			@JoinColumn(name = "TASK_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", nullable = false) })
	public Set<ApnaUser> getTaskUsers() {
		return taskUsers;
	}
	
	/**
	 * Sets the task users.
	 *
	 * @param taskUsers the new task users
	 */
	public void setTaskUsers(Set<ApnaUser> taskUsers) {
		this.taskUsers = taskUsers;
	}
}
