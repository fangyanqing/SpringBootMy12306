package com.neuedu.catshop.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.catshop.entity.FileResult;

public class FileuploadUtil {
	private static final String IMAGES = "images";
	private static PropertiesUtils pros = PropertiesUtils.getInstance();
	private static Logger logger = Logger.getLogger(FileuploadUtil.class);

	private static String getUploadPath() {
		String base = pros.getProperty("web.upload-path");
		if (base != null) {
			File path = new File(base, IMAGES);
			path.mkdirs();
			return path.getAbsolutePath();
		}
		return null;
	}

	/**
	 * 
	 * @param file
	 * @return 成功返回文件信息，失败返回-null
	 */
	public static final FileResult uplaodFile(MultipartFile file) {
		String path = getUploadPath();
		FileResult result = new FileResult(false, null);
		if (path != null && file != null && !file.isEmpty()) {

			long realSize = file.getSize();
			
			/*
			 * String s = pros.getProperty("spring.servlet.multipart.max-file-size"); long
			 * fileSize = FormatUtil.sizeFormatString2Num(s); if (realSize > fileSize) {
			 * result.setMsg("文件大小超出限制！最大值"+s ); return result; }
			 */
			result.setFileSize(realSize);
			 

			String fileName = file.getOriginalFilename();
			result.setFileName(fileName);

			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			result.setExtName(extName);

			String uuid = UUID.randomUUID().toString();
			String newFileName = uuid + "." + extName;
			result.setServerPath(IMAGES + "/" + newFileName);

			File dest = new File(path, newFileName);
			try {
				file.transferTo(dest);
				result.setSuccess(true);
			} catch (IllegalStateException | IOException e) {
				logger.error("文件上传失败!", e);
				result.setMsg("文件上传失败！" + e.getMessage());
			}
		}
		return result;
	}
}
