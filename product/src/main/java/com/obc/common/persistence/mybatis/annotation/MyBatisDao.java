package com.obc.common.persistence.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MyBatisDao
 *
 * @Description: TODO 【标识MyBatis的DAO,方便
 *               {@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。】
 * @author FC
 * @date 2016年2月20日 下午8:50:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {

	String value() default "";

}
