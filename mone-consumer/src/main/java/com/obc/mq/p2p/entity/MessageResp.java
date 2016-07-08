package com.obc.mq.p2p.entity;

import java.util.Date;

public class MessageResp {
	private long   jobSeq;	   /* job系列 */
	private String taskId;	   /* 任务号 */
	private Date   submitDate; /* 发送时间 */
	private Date   expireDate; /* 应答时间 */
	private String status;	   /* 状态 */
	private String desc;	   /* 描述 */
}
