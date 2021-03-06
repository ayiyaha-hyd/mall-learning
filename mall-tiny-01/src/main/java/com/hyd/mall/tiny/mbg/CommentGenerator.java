package com.hyd.mall.tiny.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @author ayiyaha
 */
public class CommentGenerator extends DefaultCommentGenerator {
	private boolean addRemarkComments = false;

	/**
	 * 自定义注释生成器
	 * @param properties
	 */
	@Override
	public void addConfigurationProperties(Properties properties) {
		super.addConfigurationProperties(properties);
		this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
	}

	/**
	 * 给字段添加注释
	 * @param field
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		String remarks = introspectedColumn.getRemarks();
		if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
			addFieldJavaDoc(field, remarks);
		}
	}

	/**
	 * 给model的字段添加注释
	 * @param field
	 * @param remarks
	 */
	private void addFieldJavaDoc(Field field, String remarks) {
		field.addJavaDocLine("/**");
		String[] remarkLines = remarks.split(System.getProperty("line.separator"));
		for (String remarkLine : remarkLines) {
			field.addJavaDocLine(" * " + remarkLine);
		}
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}
}
