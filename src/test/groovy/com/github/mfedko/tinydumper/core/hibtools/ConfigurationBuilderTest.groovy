package com.github.mfedko.tinydumper.core.hibtools

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.sql.DataSource

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
class ConfigurationBuilderTest {

    @Autowired DataSource db

    @Test
    void testBuildConfiguration() {

        new ConfigurationBuilder(hibernateProperties: 'hibernate-hsql.properties')
                .buildConfiguration()
    }
}
