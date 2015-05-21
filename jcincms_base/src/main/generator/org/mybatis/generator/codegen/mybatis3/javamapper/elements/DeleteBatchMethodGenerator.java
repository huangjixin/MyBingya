/*
 *  Copyright 2009 The Apache Software Foundation
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
package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;

/**
 * 
 * @author 黄记新
 * 
 */
public class DeleteBatchMethodGenerator extends
        AbstractJavaMapperMethodGenerator {

    public DeleteBatchMethodGenerator() {
        super();
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
    	Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
        FullyQualifiedJavaType listType = FullyQualifiedJavaType
                .getNewListInstance();

        importedTypes.add(listType);
//        System.out.println(introspectedTable.getPrimaryKeyType());
//        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
//                introspectedTable.getPrimaryKeyType());
//        introspectedTable.getPrimaryKeyColumns().get(0).getJdbcType();
//        listType.addTypeArgument(type);
        
        method.setReturnType(returnType);
        method.setName("deleteBatch");
        method.addParameter(new Parameter(listType, "list"));
        
        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
        
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
        return;
    }
}