package com.lm.generator;

import java.io.FileInputStream;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	public static void main(String[] args) throws Exception {
				String configFile="E:/shsoft/user_cms/src/main/resources/generate/generatorConfig.xml";
				ConfigurationParser cp=new ConfigurationParser(null,null);
				Configuration config=cp.parseConfiguration(new FileInputStream(configFile));
				DefaultShellCallback callback=new DefaultShellCallback(true);
				MyBatisGenerator myBatisGenerator =new MyBatisGenerator(config,callback,null);
				myBatisGenerator.generate(null);
	}
}
