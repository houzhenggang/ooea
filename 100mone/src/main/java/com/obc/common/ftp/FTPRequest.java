package com.obc.common.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: FTPRequest
 *
 * @Description: TODO 【ftp文件上传下载】
 * @author FC
 * @date 2016年2月20日 下午8:51:23
 */
public class FTPRequest {

	private static Logger logger = Logger.getLogger("Log");
	private String ftpHost;
	private int port;
	private String ftpPath; // 文件在ftp server上的路径
	private String userName;
	private String password;
	private String localPath;// 文件在本地的路径
	private List<String> fileName = new ArrayList<String>(); // 操作的文件名

	private FTPRequest ( ) {
	}

	public static FTPRequest newInstance ( ) {
		return new FTPRequest();
	}

	public FTPRequest addFTPPath ( String path ) {
		this.ftpPath = path;
		return this;
	}

	public FTPRequest addFTPHost ( String host ) {
		this.ftpHost = host;
		return this;
	}

	public FTPRequest addUserName ( String userName ) {
		this.userName = userName;
		return this;
	}

	public FTPRequest addPassword ( String password ) {
		this.password = password;
		return this;
	}

	public FTPRequest addLocalPath ( String localPath ) {
		this.localPath = localPath;
		return this;
	}

	public FTPRequest addFileName ( String fileName ) {
		this.fileName.add(fileName);
		return this;
	}

	public FTPRequest addFileNames ( List<String> fileName ) {
		this.fileName = fileName;
		return this;
	}

	public FTPRequest addPort ( int port ) {
		this.port = port;
		return this;
	}

	/**
	 * 
	 * @Title: downFile
	 * 
	 * @author FC
	 * @Description: TODO 【下载】
	 * @throws Exception
	 * @return void
	 * @date 2016年2月20日 下午9:00:52
	 */
	public void downFile ( ) throws Exception {

		FTPClient ftp = new FTPClient();

		try {
			ftp.setConnectTimeout(5000);
			ftp.connect(this.ftpHost, this.port);
			ftp.login(this.userName, this.password);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				throw new Exception("不能访问ftp主机!");
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			createDirecroty(ftp);
			initLocalPath();
			FTPFile[] fs = ftp.listFiles();
			boolean isDowned = false;

			logger.info("【文件:" + this.fileName + "开始下载 ,下载路径为：" + this.ftpPath + "】");

			for (int i = 0; i < fs.length; i++) {
				FTPFile file = fs[i];
				if (this.fileName.contains(file.getName())) {
					File localFile = new File(this.localPath + file.getName());
					OutputStream is = new FileOutputStream(localFile);
					isDowned = ftp.retrieveFile(file.getName(), is);
					if (isDowned) {
						logger.info("【下载文件:" + file.getName() + " 成功!!!】");
					} else {
						throw new Exception("【下载文件:" + file.getName() + " 失败!!!】");
					}
					is.close();
				}

			}
			ftp.logout();
		} catch (Exception e) {
			throw e;
		} finally {
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
	}

	/**
	 * 
	 * @Title: uploadFile
	 * 
	 * @author FC
	 * @Description: TODO 【上传】
	 * @throws Exception
	 * @return void
	 * @date 2016年2月20日 下午9:00:45
	 */
	public void uploadFile ( ) throws Exception {
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.setConnectTimeout(5000);
			ftp.connect(this.ftpHost, this.port);
			ftp.login(this.userName, this.password);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				throw new Exception("不能访问ftp主机!");
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			createDirecroty(ftp);
			for (String upLoadFileName : this.fileName) {
				File uploadFile = new File(this.localPath + upLoadFileName);
				logger.info("【文件:" + this.fileName + "开始上传 ,上传路径为：" + this.ftpPath + "】");
				FileInputStream input = new FileInputStream(uploadFile);
				boolean isSuccess = ftp.storeFile(upLoadFileName, input);
				if (isSuccess) {
					logger.info("【上传文件:" + this.fileName + " 成功!!!】");
				} else {
					throw new Exception("【上传文件:" + upLoadFileName + " 失败!!!】");
				}
				input.close();
				input = null;
			}
			ftp.logout();
		} catch (Exception e) {
			throw e;
		} finally {
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
	}

	/**
	 * 
	 * @Title: initLocalPath
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @throws Exception
	 * @return void
	 * @date 2016年2月20日 下午9:00:39
	 */
	public void initLocalPath ( ) throws Exception {
		if (StringUtils.isNotEmpty(this.localPath) && !StringUtils.equals("", this.localPath)) {
			File dirs = new File(this.localPath);
			if (!dirs.exists()) {// 不存在则创建
				dirs.mkdirs();
			}
		}
	}

	/**
	 * 
	 * @Title: createDirecroty
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param ftpClient
	 * @throws Exception
	 * @return void
	 * @date 2016年2月20日 下午9:00:27
	 */
	private void createDirecroty ( FTPClient ftpClient ) throws Exception {
		if (this.ftpPath.startsWith("/")) {
			ftpClient.changeWorkingDirectory("/");
		}
		String[] directorys = this.ftpPath.split("/");
		for (int i = 0; i < directorys.length; i++) {
			// 每级目录名称
			String directory = directorys[i];
			if (StringUtils.isNotEmpty(directory) && !StringUtils.equals("", directory.trim())) {
				if (!ftpClient.changeWorkingDirectory(directory)) {

					ftpClient.makeDirectory(directory);
					ftpClient.changeWorkingDirectory(directory);
				}
			}
		}
	}

}
