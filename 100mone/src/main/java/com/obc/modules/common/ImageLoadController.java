package com.obc.modules.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.obc.common.constant.Canonical;

/**
 * 
 * @ClassName: ImageLoadController
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年5月30日 下午7:01:08
 */
@Controller
@RequestMapping( "/common" )
@Scope
public class ImageLoadController {

	/**
	 * 
	 * @Title: imgUpLoad
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param request
	 * @return
	 * @throws OSSException
	 * @throws ClientException
	 * @throws IOException
	 * @date 2016年5月30日 下午7:01:12
	 */
	@RequestMapping( "imgUpLoad.do" )
	@ResponseBody
	public Map<String, Object> imgUpLoad ( HttpServletRequest request )	throws OSSException ,
																		ClientException ,
																		IOException {

		String myFolder = "zoel9EK8jeml0kejd9k";

		Map<String, Object> result = new HashMap<String, Object>();
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			//转换成多部分request  
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				//取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null && StringUtils.isNotEmpty(file.getOriginalFilename())
						&& !StringUtils.equals(file.getOriginalFilename().trim(), "")) {
					// 创建OSSClient实例
					OSSClient ossClient = new OSSClient(Canonical.endpoint, Canonical.accessKeyId,
							Canonical.accessKeySecret);
					// 上传文件
					ossClient.putObject(Canonical.BucketMyImg, myFolder + "/" + file.getOriginalFilename(),
							file.getInputStream());
					// 关闭client
					ossClient.shutdown();
					result.put("status", true);
				}
			}
		}

		return result;
	}

}
