package hr.optimit.hibernate.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * UtTask generated by hbm2java.
 */
@Entity
@Table(name = "UT_TASK")
public class UtTask implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The task id. */
	private Long taskId;
	
	/** The ut project. */
	private UtProject utProject;
	
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
	private String taskBillable;
	
	/** The sys modification timestamp. */
	private Timestamp sysModificationTimestamp;
	
	/** The sys modification user. */
	private Long sysModificationUser;
	
	/** The ut user2tasks. */
	private Set<UtUser2task> utUser2tasks = new HashSet<UtUser2task>(0);
	
	/** The ut activities. */
	private Set<UtActivity> utActivities = new HashSet<UtActivity>(0);

	/**
	 * Instantiates a new ut task.
	 */
	public UtTask() {
	}

	/**
	 * Instantiates a new ut task.
	 *
	 * @param taskId the task id
	 * @param utProject the ut project
	 * @param taskName the task name
	 * @param taskStartDate the task start date
	 * @param taskBillable the task billable
	 * @param sysModificationTimestamp the sys modification timestamp
	 * @param sysModificationUser the sys modification user
	 */
	public UtTask(Long taskId, UtProject utProject, String taskName, Date taskStartDate, String taskBillable,
			Timestamp sysModificationTimestamp, Long sysModificationUser) {
		this.taskId = taskId;
		this.utProject = utProject;
		this.taskName = taskName;
		this.taskStartDate = taskStartDate;
		this.taskBillable = taskBillable;
		this.sysModificationTimestamp = sysModificationTimestamp;
		this.sysModificationUser = sysModificationUser;
	}

	/**
	 * Instantiates a new ut task.
	 *
	 * @param taskId the task id
	 * @param utProject the ut project
	 * @param taskName the task name
	 * @param taskDescription the task description
	 * @param taskRef the task ref
	 * @param taskStartDate the task start date
	 * @param taskEndDate the task end date
	 * @param taskBillable the task billable
	 * @param sysModificationTimestamp the sys modification timestamp
	 * @param sysModificationUser the sys modification user
	 * @param utUser2tasks the ut user2tasks
	 * @param utActivities the ut activities
	 */
	public UtTask(Long taskId, UtProject utProject, String taskName, String taskDescription, String taskRef,
			Date taskStartDate, Date taskEndDate, String taskBillable, Timestamp sysModificationTimestamp,
			Long sysModificationUser, Set<UtUser2task> utUser2tasks, Set<UtActivity> utActivities) {
		this.taskId = taskId;
		this.utProject = utProject;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskRef = taskRef;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.taskBillable = taskBillable;
		this.sysModificationTimestamp = sysModificationTimestamp;
		this.sysModificationUser = sysModificationUser;
		this.utUser2tasks = utUser2tasks;
		this.utActivities = utActivities;
	}

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
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
	 * Gets the ut project.
	 *
	 * @return the ut project
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_PROJECT_ID", nullable = false)
	public UtProject getUtProject() {
		return this.utProject;
	}

	/**
	 * Sets the ut project.
	 *
	 * @param utProject the new ut project
	 */
	public void setUtProject(UtProject utProject) {
		this.utProject = utProject;
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
		return this.taskDescription;
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
	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_START_DATE", nullable = false, length = 7)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_END_DATE", length = 7)
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
	@Column(name = "TASK_BILLABLE", nullable = false, length = 20)
	public String getTaskBillable() {
		return this.taskBillable;
	}

	/**
	 * Sets the task billable.
	 *
	 * @param taskBillable the new task billable
	 */
	public void setTaskBillable(String taskBillable) {
		this.taskBillable = taskBillable;
	}

	/**
	 * Gets the sys modification timestamp.
	 *
	 * @return the sys modification timestamp
	 */
	@Column(name = "SYS_MODIFICATION_TIMESTAMP", nullable = false)
	public Timestamp getSysModificationTimestamp() {
		return this.sysModificationTimestamp;
	}

	/**
	 * Sets the sys modification timestamp.
	 *
	 * @param sysModificationTimestamp the new sys modification timestamp
	 */
	public void setSysModificationTimestamp(Timestamp sysModificationTimestamp) {
		this.sysModificationTimestamp = sysModificationTimestamp;
	}

	/**
	 * Gets the sys modification user.
	 *
	 * @return the sys modification user
	 */
	@Column(name = "SYS_MODIFICATION_USER", nullable = false)
	public Long getSysModificationUser() {
		return this.sysModificationUser;
	}

	/**
	 * Sets the sys modification user.
	 *
	 * @param sysModificationUser the new sys modification user
	 */
	public void setSysModificationUser(Long sysModificationUser) {
		this.sysModificationUser = sysModificationUser;
	}

	/**
	 * Gets the ut user2tasks.
	 *
	 * @return the ut user2tasks
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utTask")
	public Set<UtUser2task> getUtUser2tasks() {
		return this.utUser2tasks;
	}

	/**
	 * Sets the ut user2tasks.
	 *
	 * @param utUser2tasks the new ut user2tasks
	 */
	public void setUtUser2tasks(Set<UtUser2task> utUser2tasks) {
		this.utUser2tasks = utUser2tasks;
	}

	/**
	 * Gets the ut activities.
	 *
	 * @return the ut activities
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utTask")
	public Set<UtActivity> getUtActivities() {
		return this.utActivities;
	}

	/**
	 * Sets the ut activities.
	 *
	 * @param utActivities the new ut activities
	 */
	public void setUtActivities(Set<UtActivity> utActivities) {
		this.utActivities = utActivities;
	}

}
