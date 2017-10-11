package com.loisance.istic;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.Factory;

public class MyClassProcessor extends AbstractProcessor<CtMethod> {
    @Override
    public void process(CtMethod element) {
        Factory f = element.getFactory();
        CtCodeSnippetStatement stmt = f.createCodeSnippetStatement("System.out.println(\"Hello world\")");
        element.getBody().insertBegin(stmt);
    }
}
