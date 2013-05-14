package com.github.mfedko.tinydumper.core.hibtools

import org.junit.Test

class ConfigurationBuilderTest {

    @Test
    void testBuildConfiguration() {

        new ConfigurationBuilder(hibernateProperties: 'hibernate-hsql.properties')
                .buildConfiguration()
    }
}
