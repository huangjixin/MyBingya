/*
 *  Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.api;

import static org.mybatis.generator.internal.util.ClassloaderUtility.getCustomClassloader;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.NullProgressCallback;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.generator.internal.XmlFileMergerJaxp;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * This class is the main interface to MyBatis generator. A typical execution of
 * the tool involves these steps:
 * 
 * <ol>
 * <li>Create a Configuration object. The Configuration can be the result of a
 * parsing the XML configuration file, or it can be created solely in Java.</li>
 * <li>Create a MyBatisGenerator object</li>
 * <li>Call one of the generate() methods</li>
 * </ol>
 * 
 * @see org.mybatis.generator.config.xml.ConfigurationParser
 * 
 * @author Jeff Butler
 */
public class MyBatisGenerator {

    private Configuration configuration;

    private ShellCallback shellCallback;

    private List<GeneratedJavaFile> generatedJavaFiles;

    private List<GeneratedXmlFile> generatedXmlFiles;

    private List<String> warnings;

    private Set<String> projects;

    /**
     * Constructs a MyBatisGenerator object.
     * 
     * @param configuration
     *            The configuration for this invocation
     * @param shellCallback
     *            an instance of a ShellCallback interface. You may specify
     *            <code>null</code> in which case the DefaultShellCallback will
     *            be used.
     * @param warnings
     *            Any warnings generated during execution will be added to this
     *            list. Warnings do not affect the running of the tool, but they
     *            may affect the results. A typical warning is an unsupported
     *            data type. In that case, the column will be ignored and
     *            generation will continue. You may specify <code>null</code> if
     *            you do not want warnings returned.
     * @throws InvalidConfigurationException
     *             if the specified configuration is invalid
     */
    public MyBatisGenerator(Configuration configuration, ShellCallback shellCallback,
            List<String> warnings) throws InvalidConfigurationException {
        super();
        if (configuration == null) {
            throw new IllegalArgumentException(getString("RuntimeError.2")); //$NON-NLS-1$
        } else {
            this.configuration = configuration;
        }

        if (shellCallback == null) {
            this.shellCallback = new DefaultShellCallback(false);
        } else {
            this.shellCallback = shellCallback;
        }

        if (warnings == null) {
            this.warnings = new ArrayList<String>();
        } else {
            this.warnings = warnings;
        }
        generatedJavaFiles = new ArrayList<GeneratedJavaFile>();
        generatedXmlFiles = new ArrayList<GeneratedXmlFile>();
        projects = new HashSet<String>();

        this.configuration.validate();
    }

    /**
     * This is the main method for generating code. This method is long running,
     * but progress can be provided and the method can be canceled through the
     * ProgressCallback interface. This version of the method runs all
     * configured contexts.
     * 
     * @param callback
     *            an instance of the ProgressCallback interface, or
     *            <code>null</code> if you do not require progress information
     * @throws SQLException
     * @throws IOException
     * @throws InterruptedException
     *             if the method is canceled through the ProgressCallback
     */
    public void generate(ProgressCallback callback) throws SQLException,
            IOException, InterruptedException {
        generate(callback, null, null);
    }

    /**
     * This is the main method for generating code. This method is long running,
     * but progress can be provided and the method can be canceled through the
     * ProgressCallback interface.
     * 
     * @param callback
     *            an instance of the ProgressCallback interface, or
     *            <code>null</code> if you do not require progress information
     * @param contextIds
     *            a set of Strings containing context ids to run. Only the
     *            contexts with an id specified in this list will be run. If the
     *            list is null or empty, than all contexts are run.
     * @throws InvalidConfigurationException
     * @throws SQLException
     * @throws IOException
     * @throws InterruptedException
     *             if the method is canceled through the ProgressCallback
     */
    public void generate(ProgressCallback callback, Set<String> contextIds)
            throws SQLException, IOException, InterruptedException {
        generate(callback, contextIds, null);
    }

    /**
     * This is the main method for generating code. This method is long running,
     * but progress can be provided and the method can be cancelled through the
     * ProgressCallback interface.
     * 
     * @param callback
     *            an instance of the ProgressCallback interface, or
     *            <code>null</code> if you do not require progress information
     * @param contextIds
     *            a set of Strings containing context ids to run. Only the
     *            contexts with an id specified in this list will be run. If the
     *            list is null or empty, than all contexts are run.
     * @param fullyQualifiedTableNames
     *            a set of table names to generate. The elements of the set must
     *            be Strings that exactly match what's specified in the
     *            configuration. For example, if table name = "foo" and schema =
     *            "bar", then the fully qualified table name is "foo.bar". If
     *            the Set is null or empty, then all tables in the configuration
     *            will be used for code generation.
     * @throws InvalidConfigurationException
     * @throws SQLException
     * @throws IOException
     * @throws InterruptedException
     *             if the method is canceled through the ProgressCallback
     */
    public void generate(ProgressCallback callback, Set<String> contextIds,
            Set<String> fullyQualifiedTableNames) throws SQLException,
            IOException, InterruptedException {

        if (callback == null) {
            callback = new NullProgressCallback();
        }

        generatedJavaFiles.clear();
        generatedXmlFiles.clear();

        // calculate the contexts to run
        List<Context> contextsToRun;
        if (contextIds == null || contextIds.size() == 0) {
            contextsToRun = configuration.getContexts();
        } else {
            contextsToRun = new ArrayList<Context>();
            for (Context context : configuration.getContexts()) {
                if (contextIds.contains(context.getId())) {
                    contextsToRun.add(context);
                }
            }
        }

        // setup custom classloader if required
        if (configuration.getClassPathEntries().size() > 0) {
            ClassLoader classLoader = getCustomClassloader(configuration.getClassPathEntries());
            ObjectFactory.addExternalClassLoader(classLoader);
        }

        // now run the introspections...
        int totalSteps = 0;
        for (Context context : contextsToRun) {
            totalSteps += context.getIntrospectionSteps();
        }
        callback.introspectionStarted(totalSteps);

        for (Context context : contextsToRun) {
            context.introspectTables(callback, warnings,
                    fullyQualifiedTableNames);
        }

        // now run the generates
        totalSteps = 0;
        for (Context context : contextsToRun) {
            totalSteps += context.getGenerationSteps();
        }
        callback.generationStarted(totalSteps);

        for (Context context : contextsToRun) {
            context.generateFiles(callback, generatedJavaFiles,
                    generatedXmlFiles, warnings);
        }

        // now save the files
        callback.saveStarted(generatedXmlFiles.size()
                + generatedJavaFiles.size());

        for (GeneratedXmlFile gxf : generatedXmlFiles) {
            projects.add(gxf.getTargetProject());

            File targetFile;
            String source;
            try {
                File directory = shellCallback.getDirectory(gxf
                        .getTargetProject(), gxf.getTargetPackage());
                targetFile = new File(directory, gxf.getFileName());
                if (targetFile.exists()) {
                    if (gxf.isMergeable()) {
                        source = XmlFileMergerJaxp.getMergedSource(gxf,
                                targetFile);
                    } else if (shellCallback.isOverwriteEnabled()) {
                        source = gxf.getFormattedContent();
                        warnings.add(getString("Warning.11", //$NON-NLS-1$
                                targetFile.getAbsolutePath()));
                    } else {
                        source = gxf.getFormattedContent();
                        targetFile = getUniqueFileName(directory, gxf
                                .getFileName());
                        warnings.add(getString(
                                "Warning.2", targetFile.getAbsolutePath())); //$NON-NLS-1$
                    }
                } else {
                    source = gxf.getFormattedContent();
                }
            } catch (ShellException e) {
                warnings.add(e.getMessage());
                continue;
            }

            callback.checkCancel();
            callback.startTask(getString(
                    "Progress.15", targetFile.getName())); //$NON-NLS-1$
            writeFile(targetFile, source, "UTF-8"); //$NON-NLS-1$
        }

        for (GeneratedJavaFile gjf : generatedJavaFiles) {
            projects.add(gjf.getTargetProject());

            File targetFile;
            String source;
            try {
                File directory = shellCallback.getDirectory(gjf
                        .getTargetProject(), gjf.getTargetPackage());
                targetFile = new File(directory, gjf.getFileName());
                if (targetFile.exists()) {
                    if (shellCallback.isMergeSupported()) {
                        source = shellCallback.mergeJavaFile(gjf
                                .getFormattedContent(), targetFile
                                .getAbsolutePath(),
                                MergeConstants.OLD_ELEMENT_TAGS,
                                gjf.getFileEncoding());
                    } else if (shellCallback.isOverwriteEnabled()) {
                        source = gjf.getFormattedContent();
                        warnings.add(getString("Warning.11", //$NON-NLS-1$
                                targetFile.getAbsolutePath()));
                    } else {
                        source = gjf.getFormattedContent();
                        targetFile = getUniqueFileName(directory, gjf
                                .getFileName());
                        warnings.add(getString(
                                "Warning.2", targetFile.getAbsolutePath())); //$NON-NLS-1$
                    }
                } else {
                    source = gjf.getFormattedContent();
                }

                callback.checkCancel();
                callback.startTask(getString(
                        "Progress.15", targetFile.getName())); //$NON-NLS-1$
                writeFile(targetFile, source, gjf.getFileEncoding());
            } catch (ShellException e) {
                warnings.add(e.getMessage());
            }
        }

        for (String project : projects) {
            shellCallback.refreshProject(project);
        }

        callback.done();
        
        //--------------- 生成实现类接口
        for (Context context : contextsToRun) {
        	List<IntrospectedTable> introspectedTables = context.getIntrospectedTables();
            List<TableConfiguration> list= context.getTableConfigurations();
            for (TableConfiguration tableConfiguration : list) {
            	String path = MyBatisGenerator.class.getClassLoader().getResource("").getPath()+"freemarkerTemplate";
                freemarker.template.Configuration configuration = new freemarker.template.Configuration();
                configuration.setDirectoryForTemplateLoading(new File(path));
                Template template = configuration.getTemplate(File.separator+"ServiceImpl.ftl");
                StringWriter out = new StringWriter();
               
                String doname = tableConfiguration.getDomainObjectName();
                String fir = doname.substring(0, 1);
                String last = doname.substring(1);
                String daoMapper = fir.toLowerCase()+last;
                Map<String,Object> root = new HashMap<String, Object>();
                String moduleName = context.getProperty("moduleName"); 
                String packageName = "com.jcin.cms.service."+moduleName+".impl";
                root.put("packageName", packageName);
                root.put("domainObjectName", doname);
                root.put("daoMapper", daoMapper);
                root.put("moduleName", moduleName);
                try {
                	packageName=packageName.replace(".", File.separator);
                	File directory = shellCallback.getDirectory("src/main/java", packageName);
    				File  file = new File(directory, doname+"ServiceImpl.java");
                	template.process(root, out);
    				writeFile(file, out.toString(),null);
    	            System.out.println(out.toString());
    	            out.close();
    			} catch (TemplateException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (ShellException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }
        
        //--------------- 生成接口
        for (Context context : contextsToRun) {
        	List<TableConfiguration> list= context.getTableConfigurations();
        	for (TableConfiguration tableConfiguration : list) {
        		String path = MyBatisGenerator.class.getClassLoader().getResource("").getPath()+"freemarkerTemplate";
        		@SuppressWarnings("deprecation")
				freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        		configuration.setDirectoryForTemplateLoading(new File(path));
        		Template template = configuration.getTemplate(File.separator+"IService.ftl");
        		StringWriter out = new StringWriter();
        		
        		String doname = tableConfiguration.getDomainObjectName();
        		Map<String,Object> root = new HashMap<String, Object>();
        		String moduleName = context.getProperty("moduleName"); 
                String packageName = "com.jcin.cms.service."+moduleName;
        		root.put("packageName", packageName);
        		root.put("domainObjectName", doname);
        		root.put("moduleName", moduleName);
        		try {
        			packageName=packageName.replace(".", File.separator);
        			File directory = shellCallback.getDirectory("src/main/java", packageName);
        			File  file = new File(directory, "I"+doname+"Service.java");
        			template.process(root, out);
        			writeFile(file, out.toString(),null);
        			System.out.println(out.toString());
        			out.close();
        		} catch (TemplateException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ShellException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        }
        
        //--------------- 生成web控制器
        for (Context context : contextsToRun) {
        	List<IntrospectedTable> introspectedTables = context.getIntrospectedTables();
        	for (IntrospectedTable introspectedTable : introspectedTables) {
        		TableConfiguration tableConfiguration = introspectedTable.getTableConfiguration();
        		
        		String path = MyBatisGenerator.class.getClassLoader().getResource("").getPath()+"freemarkerTemplate";
        		@SuppressWarnings("deprecation")
				freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        		configuration.setDirectoryForTemplateLoading(new File(path));
        		Template template = configuration.getTemplate(File.separator+"Controller.ftl");
        		StringWriter out = new StringWriter();
        		
        		String doname = tableConfiguration.getDomainObjectName();
        		String fir = doname.substring(0, 1);
        		String last = doname.substring(1);
        		String objInst = fir.toLowerCase()+last;
        		Map<String,Object> root = new HashMap<String, Object>();
        		String moduleName = context.getProperty("moduleName"); 
                String packageName = "com.jcin.cms.web."+moduleName;
        		root.put("packageName", packageName);
        		root.put("domainObjectName", doname);
        		root.put("objInst", objInst);
        		root.put("moduleName", moduleName);
        		List<IntrospectedColumn> introspectedColumns = introspectedTable.getAllColumns();
        		List<String> colNames = new ArrayList<String>();
        		for (IntrospectedColumn introspectedColumn : introspectedColumns) {
        			String colName = introspectedColumn.getActualColumnName();
        			fir = colName.substring(0, 1);
        			fir = fir.toUpperCase();
        			last = colName.substring(1);
        			String col = fir+last;
        			if(col.indexOf("_") != -1){
        				int index = col.indexOf("_");
        				String torep = col.substring(index, index+2);
        				String replaced = col.substring(index+1, index+2);
        				replaced = replaced.toUpperCase();
        				col = col.replaceFirst(torep, replaced);
        			}
        			colNames.add(col);
				}
        		root.put("introspectedColumns", colNames);
        		try {
        			packageName=packageName.replace(".", File.separator);
        			File directory = shellCallback.getDirectory("src/main/java", packageName);
        			File  file = new File(directory, doname+"Controller.java");
        			template.process(root, out);
        			writeFile(file, out.toString(),null);
        			System.out.println(out.toString());
        			out.close();
        		} catch (TemplateException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ShellException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
			}
        }
        //--------------- 生成list页面
        for (Context context : contextsToRun) {
        	List<IntrospectedTable> introspectedTables = context.getIntrospectedTables();
        	for (IntrospectedTable introspectedTable : introspectedTables) {
        		TableConfiguration tableConfiguration = introspectedTable.getTableConfiguration();
        		
        		String path = MyBatisGenerator.class.getClassLoader().getResource("").getPath()+"freemarkerTemplate";
        		@SuppressWarnings("deprecation")
        		freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        		configuration.setDirectoryForTemplateLoading(new File(path));
        		Template template = configuration.getTemplate(File.separator+"list.ftl");
        		StringWriter out = new StringWriter();
        		
        		String doname = tableConfiguration.getDomainObjectName();
        		String fir = doname.substring(0, 1);
        		String last = doname.substring(1);
        		String objInst = fir.toLowerCase()+last;
        		Map<String,Object> root = new HashMap<String, Object>();
        		String moduleName = context.getProperty("moduleName"); 
        		root.put("domainObjectName", doname);
        		root.put("objInst", objInst);
        		List<IntrospectedColumn> introspectedColumns = introspectedTable.getAllColumns();
        		List<String> colNames = new ArrayList<String>();
        		for (IntrospectedColumn introspectedColumn : introspectedColumns) {
        			String colName = introspectedColumn.getActualColumnName();
        			fir = colName.substring(0, 1);
        			fir = fir.toLowerCase();
        			last = colName.substring(1);
        			String col = fir+last;
        			if(col.indexOf("_") != -1){
        				int index = col.indexOf("_");
        				String torep = col.substring(index, index+2);
        				String replaced = col.substring(index+1, index+2);
        				replaced = replaced.toUpperCase();
        				col = col.replaceFirst(torep, replaced);
        			}
        			colNames.add(col);
        		}
        		root.put("introspectedColumns", colNames);
        		try {
        			String packageName = "WEB-INF.view."+objInst;
        			File directory = shellCallback.getDirectory("src/main/webapp", packageName);
        			File  file = new File(directory, objInst+"_list.jsp");
        			template.process(root, out);
        			writeFile(file, out.toString(),null);
        			System.out.println(out.toString());
        			out.close();
        		} catch (TemplateException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ShellException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		template = configuration.getTemplate(File.separator+"create.ftl");
        		out = new StringWriter();
        		try {
        			String packageName = "WEB-INF.view."+objInst;
        			File directory = shellCallback.getDirectory("src/main/webapp", packageName);
        			File  file = new File(directory, objInst+"_create.jsp");
        			template.process(root, out);
        			writeFile(file, out.toString(),null);
        			System.out.println(out.toString());
        			out.close();
        		} catch (TemplateException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ShellException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		template = configuration.getTemplate(File.separator+"update.ftl");
        		out = new StringWriter();
        		try {
        			String packageName = "WEB-INF.view."+objInst;
        			File directory = shellCallback.getDirectory("src/main/webapp", packageName);
        			File  file = new File(directory, objInst+"_update.jsp");
        			template.process(root, out);
        			writeFile(file, out.toString(),null);
        			System.out.println(out.toString());
        			out.close();
        		} catch (TemplateException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ShellException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        }
    }

    /**
     * Writes, or overwrites, the contents of the specified file
     * 
     * @param file
     * @param content
     */
    private void writeFile(File file, String content, String fileEncoding) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, false);
        OutputStreamWriter osw;
        if (fileEncoding == null) {
            osw = new OutputStreamWriter(fos);
        } else {
            osw = new OutputStreamWriter(fos, fileEncoding);
        }
        
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(content);
        bw.close();
    }

    private File getUniqueFileName(File directory, String fileName) {
        File answer = null;

        // try up to 1000 times to generate a unique file name
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 1000; i++) {
            sb.setLength(0);
            sb.append(fileName);
            sb.append('.');
            sb.append(i);

            File testFile = new File(directory, sb.toString());
            if (!testFile.exists()) {
                answer = testFile;
                break;
            }
        }

        if (answer == null) {
            throw new RuntimeException(getString(
                    "RuntimeError.3", directory.getAbsolutePath())); //$NON-NLS-1$
        }

        return answer;
    }
}
