package com.otaviojava.demos.ddd;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;
import org.junit.jupiter.api.Test;

public class JMoleculesDddUnitTest {

    @Test
    void checkTheLayerIntegration() {
        String packageName = App.class.getPackageName();
        JavaClasses classes = new ClassFileImporter().importPackages(packageName);
        JMoleculesArchitectureRules.ensureLayering().check(classes);

    }

    @Test
    void checkDDDIntegration() {
        String packageName = App.class.getPackageName();
        JavaClasses classes = new ClassFileImporter().importPackages(packageName);
        JMoleculesDddRules.all().check(classes);

    }
}
