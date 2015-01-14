package com.jcin.cms.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.config.GeneratedKey;

/**
 * @author 黄记新
 * @date 2012-11-30 下午03:36:11
 */
public class PaginationPlugin extends PluginAdapter {

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// add field, getter, setter for pageSize clause
		addPageModel(topLevelClass, introspectedTable, "page");
		addDialect(topLevelClass, introspectedTable, "dialect");
		return super.modelExampleClassGenerated(topLevelClass,
				introspectedTable);
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		// 产生分页语句前半部分
		XmlElement paginationPrefixElement = new XmlElement("sql");
		paginationPrefixElement.addAttribute(new Attribute("id",
				"OracleDialectPrefix"));
		XmlElement pageStart = new XmlElement("if");
		pageStart.addAttribute(new Attribute("test", "page != null"));
		XmlElement pageDialect1 = new XmlElement("if");
		pageDialect1.addAttribute(new Attribute("test", "dialect == 'oracle'"));
		pageStart.addElement(pageDialect1);
		pageDialect1.addElement(new TextElement(
				"select * from ( select row_.*, rownum rownum_ from ( "));
		paginationPrefixElement.addElement(pageStart);
		parentElement.addElement(paginationPrefixElement);

		// 产生分页语句后半部分
		XmlElement paginationSuffixElement = new XmlElement("sql");
		paginationSuffixElement.addAttribute(new Attribute("id",
				"OracleDialectSuffix"));
		XmlElement pageEnd = new XmlElement("if");
		pageEnd.addAttribute(new Attribute("test", "page != null"));
		XmlElement pageDialect2 = new XmlElement("if");
		pageDialect2.addAttribute(new Attribute("test", "dialect == 'oracle'"));
		pageEnd.addElement(pageDialect2);
		pageDialect2
				.addElement(new TextElement(
						"<![CDATA[ ) row_ ) where rownum_ > #{page.start} and rownum_ <= #{page.pageSize} ]]>"));

		// ----- mysql语句。
		XmlElement mysqlDialect = new XmlElement("if");
		mysqlDialect.addAttribute(new Attribute("test", "dialect == 'mysql'"));
		pageEnd.addElement(mysqlDialect);
		mysqlDialect.addElement(new TextElement(
				"limit #{page.start} , #{page.pageSize}"));
		paginationSuffixElement.addElement(pageEnd);

		parentElement.addElement(paginationSuffixElement);

		// //////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////
		// 添加批量插入的节点。
		XmlElement insertBatch = new XmlElement("insert"); //$NON-NLS-1$

		insertBatch.addAttribute(new Attribute("id", "insertBatch")); //$NON-NLS-1$
		insertBatch.addAttribute(new Attribute("parameterType",
				"java.util.List"));

		StringBuilder insertClause = new StringBuilder();
		StringBuilder valuesClause = new StringBuilder();
		
		insertClause.append("insert into "); //$NON-NLS-1$
		insertClause.append(introspectedTable
				.getFullyQualifiedTableNameAtRuntime());
		insertClause.append(" (");
		valuesClause.append("(");
		Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns()
				.iterator();
		while (iter.hasNext()) {
			IntrospectedColumn introspectedColumn = iter.next();

			if (introspectedColumn.isIdentity()) {
				// cannot set values on identity fields
				continue;
			}

			insertClause.append(MyBatis3FormattingUtilities
					.getEscapedColumnName(introspectedColumn));
			
			String parameterColumnName = MyBatis3FormattingUtilities
					.getParameterClause(introspectedColumn);
			String columnName = MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn);
			parameterColumnName = parameterColumnName.replace(columnName, "item."+columnName);
			valuesClause.append(parameterColumnName);
//			valuesClause.append("#{item.");
//			valuesClause.append(MyBatis3FormattingUtilities
//					.getEscapedColumnName(introspectedColumn));
//			valuesClause.append("}");
			
			if (iter.hasNext()) {
				insertClause.append(", "); 
				valuesClause.append(", ");
			}
			
		}

		insertClause.append(')');
		insertBatch.addElement(new TextElement(insertClause.toString()));
		valuesClause.append(")");
		insertBatch.addElement(new TextElement(" values"));

		XmlElement foreach = new XmlElement("foreach");
		foreach.addAttribute(new Attribute("collection", "list"));
		foreach.addAttribute(new Attribute("item", "item"));
		foreach.addAttribute(new Attribute("index", "index"));
		foreach.addAttribute(new Attribute("separator", ","));
		
		foreach.addElement(new TextElement(valuesClause.toString()));
		insertBatch.addElement(foreach);
		
		parentElement.addElement(insertBatch);

		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}


	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {

		XmlElement pageStart = new XmlElement("include"); //$NON-NLS-1$   
		pageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
		element.getElements().add(0, pageStart);

		XmlElement isNotNullElement = new XmlElement("include"); //$NON-NLS-1$   
		isNotNullElement.addAttribute(new Attribute("refid",
				"OracleDialectSuffix"));
		element.getElements().add(isNotNullElement);

		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
				introspectedTable);
	}

//	private void addInsertBatch(TopLevelClass topLevelClass,
//			IntrospectedTable introspectedTable, String name) {
//		CommentGenerator commentGenerator = context.getCommentGenerator();
//		Method method = new Method();
//		method.setVisibility(JavaVisibility.PUBLIC);
//		method.setName(name);
//		method.addParameter(new Parameter(new FullyQualifiedJavaType("List"),
//				name));
//		method.addBodyLine("this." + name + "=" + name + ";");
//		commentGenerator.addGeneralMethodComment(method, introspectedTable);
//		topLevelClass.addMethod(method);
//	}
	
	/**
	 * @param topLevelClass
	 * @param introspectedTable
	 * @param name
	 */
	private void addDialect(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable, String name) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PRIVATE);
		field.setType(new FullyQualifiedJavaType("String"));
		field.setName(name + " = \"mysql\"");
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"),
				name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType("String"));
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * @param topLevelClass
	 * @param introspectedTable
	 * @param name
	 */
	private void addPageModel(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable, String name) {
		topLevelClass.addImportedType(new FullyQualifiedJavaType(
				"com.jcin.cms.utils.Page"));
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(new FullyQualifiedJavaType("com.jcin.cms.utils.Page"));
		field.setName(name);
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(new FullyQualifiedJavaType(
				"com.jcin.cms.utils.Page"), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType(
				"com.jcin.cms.utils.Page"));
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	public static void generate() {
		String config = PaginationPlugin.class.getClassLoader()
				.getResource("generatorConfig.xml").getFile();
		String[] arg = { "-configfile", config, "-overwrite" };
		ShellRunner.main(arg);
	}

	public static void main(String[] args) {
		generate();
	}
}
