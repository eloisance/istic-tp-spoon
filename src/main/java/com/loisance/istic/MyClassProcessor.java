package com.loisance.istic;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.factory.Factory;

public class MyClassProcessor extends AbstractProcessor<CtClass> {
    @Override
    public void process(CtClass element) {
        Factory f = element.getFactory();
        CtCodeSnippetStatement stmt = f.createCodeSnippetStatement("System.out.println(\"Hello world\"");
    }
}
