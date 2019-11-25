package com.neuedu.catshop.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.neuedu.catshop.entity.Result;


/**
 * 全局异常处理器，用于捕获系统主要异常，并进行操作提示！
 * 
 * @author netboy
 *
 */
@ControllerAdvice
public class GlobalException {
	private Logger logger = Logger.getLogger(GlobalException.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		logger.error("系统日志", e);

		if (e instanceof MaxUploadSizeExceededException) {
			return new Result(false, "文件大小超出限制！ ");
		}

		return new Result(false, "操作有误或发生服务器故障！ ");
	}

}
