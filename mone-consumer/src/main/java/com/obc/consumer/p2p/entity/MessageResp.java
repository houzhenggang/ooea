package com.obc.consumer.p2p.entity;

import java.util.Date;
/**
 * 
 * <br>类名： MessageResp 
 *
 * <br>公司名称： 【】
 * <br>描述：【消息响应】
 * <br>创建时间： 2016年7月8日 上午10:58:31 
 * @author dogesoft
 */
public class MessageResp {
	
	private long   jobSeq;	   /* job系列 */
	private String taskId;	   /* 任务号 */
	private Date   submitDate; /* 发送时间 */
	private Date   expireDate; /* 应答时间 */
	private String status;	   /* 状态 */
	private String desc;	   /* 描述 */
	
	public long getJobSeq ( ) {
		return jobSeq;
	}
	public void setJobSeq ( long jobSeq ) {
		this.jobSeq = jobSeq;
	}
	public String getTaskId ( ) {
		return taskId;
	}
	public void setTaskId ( String taskId ) {
		this.taskId = taskId;
	}
	public Date getSubmitDate ( ) {
		return submitDate;
	}
	public void setSubmitDate ( Date submitDate ) {
		this.submitDate = submitDate;
	}
	public Date getExpireDate ( ) {
		return expireDate;
	}
	public void setExpireDate ( Date expireDate ) {
		this.expireDate = expireDate;
	}
	public String getStatus ( ) {
		return status;
	}
	public void setStatus ( String status ) {
		this.status = status;
	}
	public String getDesc ( ) {
		return desc;
	}
	public void setDesc ( String desc ) {
		this.desc = desc;
	}
	
	
}
