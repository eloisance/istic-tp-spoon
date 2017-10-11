package com.loisance.istic;

import spoon.Launcher;
import spoon.reflect.CtModel;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Launcher launcher = new Launcher();
        launcher.getEnvironment().setAutoImports(true);
        launcher.getEnvironment().setNoClasspath(true);

        File inDir = new File("/home/eloisance/workspace/DummyProject/src");

        launcher.addInputResource(inDir.getPath());
        launcher.buildModel();

        CtModel root = launcher.getModel();

        root.getAllPackages().forEach(p -> {
            System.out.println("package: " + p.getQualifiedName());
            p.getTypes().forEach(t -> {
                System.out.println("type: " + t.getSimpleName());
                t.getMethods().forEach(m -> {
                    System.out.println("method: " + m.getSimpleName());
                });
            });
        });

        // add Processor
        launcher.addProcessor(new MyClassProcessor());

        // print the transformed code!
        File outDir = new File("/home/eloisance/workspace/DummyProject/gen");
        launcher.setSourceOutputDirectory(outDir.getPath());
        launcher.prettyprint();
    }
}
