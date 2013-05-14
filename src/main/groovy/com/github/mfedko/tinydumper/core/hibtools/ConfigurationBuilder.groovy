package com.github.mfedko.tinydumper.core.hibtools

import org.apache.commons.lang.StringUtils

class ConfigurationBuilder {

    def hibernateProperties

    def buildConfiguration() {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader) cl).getURLs();

//        for(URL url: urls){
//            System.out.println(url.file);
//        }

        def ant = new AntBuilder()
        def PATH = 'toolslib'

        def String[] toolsJars = ['hibernate-tools', 'hibernate3', 'freemarker']

        ant.path(id: PATH) {
            urls.each { url ->
                if (StringUtils.indexOfAny(url.file, toolsJars)) {
                    ant.pathelement(location: url.file)
                }
            }
        }

//        ant.echo(ant.path(PATH))
        ant.taskdef(name: 'hibernatetool', classname: 'org.hibernate.tool.ant.HibernateToolTask', classpathref: PATH)

        def tmpDest = File.createTempDir('hibtool', '')

        ant.hibernatetool(destDir: tmpDest.absolutePath) {

            jdbcconfiguration(propertyfile: cl.getResource(hibernateProperties).file)
            hbm2ddl(
                    export: "false",
                    update: "false",
                    outputfilename: "model_ddl.sql",
                    format: "true",
                    haltonerror: "false"
            )
        }

        println "DDL:\n ${new File(tmpDest, 'model_ddl.sql').text}"
    }
}
