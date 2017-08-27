package hr.optimit.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class UtTaskDTO.
 */
public class UtTaskDTO {

	/** The id. */
	private Long id;
	
	/** The task name. */
	private String taskName;
	
	/** The project id. */
	private Long projectId;
	
	/** The task start date. */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date taskStartDate;
	
	/** The task end date. */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date taskEndDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
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
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId the new project id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the task start date.
	 *
	 * @return the task start date
	 */
	public Date getTaskStartDate() {
		return taskStartDate;
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
	public Date getTaskEndDate() {
		return taskEndDate;
	}

	/**
	 * Sets the task end date.
	 *
	 * @param taskEndDate the new task end date
	 */
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
}
