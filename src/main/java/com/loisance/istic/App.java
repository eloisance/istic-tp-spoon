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

        root.getAllPackages().stream().forEach(
                p -> System.out.println("p: " + p.getQualifiedName())
        );

        root.getAllPackages().stream().forEach(
                p -> p.getTypes().forEach(
                        t -> t.getMethods().forEach(
                                m -> System.out.println(m.getSimpleName())
                        )
                )
        );

        // add Processor
        launcher.addProcessor(new MyClassProcessor());

        // print the transformed code!
        File outDir = new File("/home/eloisance/workspace/DummyProject/gen");
        launcher.setSourceOutputDirectory(outDir.getPath());
        launcher.prettyprint();
    }
}
