/**
 *    Copyright 2006-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class SelectByConditionMethodGenerator extends
        AbstractJavaMapperMethodGenerator {

    public SelectByConditionMethodGenerator() {
        super();
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = introspectedTable.getRules()
                .calculateAllFieldsClass();
        FullyQualifiedJavaType returnTypeList = new FullyQualifiedJavaType("java.util.List");
        //FullyQualifiedJavaType returnTypeList = new FullyQualifiedJavaType("com.github.pagehelper.Page");
        method.setReturnType(returnTypeList);
        importedTypes.add(returnType);
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        //importedTypes.add(new FullyQualifiedJavaType("com.github.pagehelper.Page"));

        method.setName("selectByCondition");

        method.addParameter(new Parameter(returnType, "condition")); //$NON-NLS-1$

        addExtraImports(interfaze);
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
    }

    public void addExtraImports(Interface interfaze) {
    }
}
